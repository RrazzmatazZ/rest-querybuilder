package com.dreamtail.querybuilder.support;

import com.dreamtail.querybuilder.base.BaseService;
import com.dreamtail.querybuilder.base.Expression;
import com.dreamtail.querybuilder.base.enums.Comparison;
import com.dreamtail.querybuilder.base.enums.Operator;
import com.dreamtail.querybuilder.base.exceptions.ArgsWrongLenException;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.Arrays;

/**
 * @author xdq
 * @version 1.0
 * @className ESQuery
 * @description TODO
 * @date 2021/7/2 13:54
 */
public class ESQuery<M> extends BaseService<NativeSearchQueryBuilder, M> {

    public ESQuery(Class<M> clazz) {
        this.setEntityClass(clazz);
    }

    @Override
    protected NativeSearchQueryBuilder buildQueryCondition(Expression searchModel) throws Exception {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        this.buildNativeQueryBuilder(boolQueryBuilder, searchModel);
        queryBuilder.withQuery(boolQueryBuilder);
        return queryBuilder;
    }

    private void buildNativeQueryBuilder(BoolQueryBuilder boolQueryBuilder, Expression expression) {
        Operator operator = this.getOperator(expression.getOperator());
        for (String[] arg : expression.getArgs()) {
            this.buildNativeQueryComparison(boolQueryBuilder, arg, operator);
        }
        if (expression.getChild() != null && expression.getChild().length > 0) {
            BoolQueryBuilder childBoolQueryBuilder = QueryBuilders.boolQuery();
            for (Expression childExpr : expression.getChild()) {
                this.buildNativeQueryBuilder(childBoolQueryBuilder, childExpr);
            }
            if (operator.equals(Operator.ALL)) {
                boolQueryBuilder.must(childBoolQueryBuilder);
            } else {
                boolQueryBuilder.should(childBoolQueryBuilder);
            }
        }
    }

    private void buildNativeQueryComparison(BoolQueryBuilder queryBuilder, String[] arg, Operator operator) {
        if (arg.length < 3) throw new ArgsWrongLenException("args length not right,should be more than 3!");
        String param = this.toUnderline(arg[0]);
        this.checkQueryParam(param);
        Comparison comparison = this.getComparison(arg[1]);
        QueryBuilder argQueryBuilder = null;
        switch (comparison) {
            case GT:
                argQueryBuilder = QueryBuilders.rangeQuery(param).gt(arg[2]);
                break;
            case GTE:
                argQueryBuilder = QueryBuilders.rangeQuery(param).gte(arg[2]);
                break;
            case LT:
                argQueryBuilder = QueryBuilders.rangeQuery(param).lt(arg[2]);
                break;
            case LTE:
                argQueryBuilder = QueryBuilders.rangeQuery(param).lte(arg[2]);
                break;
            case EQ:
                argQueryBuilder = QueryBuilders.termQuery(param, arg[2]);
                break;
            case LIKE:
                argQueryBuilder = QueryBuilders.matchQuery(param, arg[2]);
                break;
            case NEG:
                argQueryBuilder = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery(param, arg[2]));
                break;
            case IN:
                String[] inArgs = Arrays.copyOfRange(arg, 2, arg.length);
                argQueryBuilder = QueryBuilders.termsQuery(param, inArgs);
                break;
        }
        if (argQueryBuilder != null) {
            if (operator.equals(Operator.ALL)) {
                queryBuilder.must(argQueryBuilder);
            } else {
                queryBuilder.should(argQueryBuilder);
            }
        }
    }
}
