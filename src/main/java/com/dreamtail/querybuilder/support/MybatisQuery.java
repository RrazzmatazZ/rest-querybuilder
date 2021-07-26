package com.dreamtail.querybuilder.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamtail.querybuilder.base.BaseService;
import com.dreamtail.querybuilder.base.Expression;
import com.dreamtail.querybuilder.base.enums.Comparison;
import com.dreamtail.querybuilder.base.enums.Operator;
import com.dreamtail.querybuilder.base.exceptions.ArgsWrongLenException;

import java.util.Arrays;

/**
 * @author xdq
 * @version 1.0
 * @className MybatisQuery
 * @description TODO
 * @date 2021/7/2 13:54
 */
public class MybatisQuery<M> extends BaseService<QueryWrapper<M>> {

    @Override
    public QueryWrapper<M> buildQueryCondition(Expression expression) throws Exception {
        QueryWrapper<M> queryWrapper = new QueryWrapper<>();
        this.buildMybatisQueryWithChild(queryWrapper, expression);
        return queryWrapper;
    }

    private void buildMybatisQueryWithChild(QueryWrapper<M> queryWrapper, Expression expression){
        Operator operator = this.getOperator(expression.getOperator());
        for (int i = 0; i < expression.getArgs().size(); i++) {
            String[] arg = expression.getArgs().get(i);
            if (operator.equals(Operator.ANY) && i > 0) queryWrapper.or();
            this.buildMybatisQueryComparison(queryWrapper, arg);
        }

        if (expression.getChild() != null && expression.getChild().length > 0) {
            if (operator.equals(Operator.ANY)){
                queryWrapper.or(wrapper->{
                    for (Expression childExpr : expression.getChild()) {
                        this.buildMybatisQueryWithChild(wrapper, childExpr);
                    }
                });
            }else {
                queryWrapper.or(wrapper->{
                    for (Expression childExpr : expression.getChild()) {
                        this.buildMybatisQueryWithChild(wrapper, childExpr);
                    }
                });
            }
        }
    }

    private void buildMybatisQueryComparison(QueryWrapper<M> queryWrapper, String[] arg) {
        if (arg.length < 3) throw new ArgsWrongLenException("args length not right,should be more than 3!");
        String param = this.toUnderline(arg[0]);
        //todo 判断param是否在查询类M的param中
        Comparison comparison = this.getComparison(arg[1]);
        switch (comparison) {
            case GT:
                queryWrapper.gt(param, arg[2]);
                break;
            case GTE:
                queryWrapper.ge(param, arg[2]);
                break;
            case LT:
                queryWrapper.lt(param, arg[2]);
                break;
            case LTE:
                queryWrapper.le(param, arg[2]);
                break;
            case EQ:
                queryWrapper.eq(param, arg[2]);
                break;
            case LIKE:
                queryWrapper.like(param, arg[2]);
                break;
            case NEG:
                queryWrapper.ne(param, arg[2]);
                break;
            case IN:
                String[] inArgs = Arrays.copyOfRange(arg, 2, arg.length - 1);
                queryWrapper.in(param, inArgs);
                break;
        }
    }

}