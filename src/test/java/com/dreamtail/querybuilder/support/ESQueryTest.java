package com.dreamtail.querybuilder.support;

import com.alibaba.fastjson.JSONObject;
import com.dreamtail.querybuilder.base.Expression;
import com.dreamtail.querybuilder.examples.User;
import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import static org.junit.Assert.*;

public class ESQueryTest {

    @Test
    public void testBuildQuery() throws Exception {
        String expr = "{\"args\":[[\"age\",\"gt\",\"20\"],[\"name\",\"like\",\"john\"]],\"child\":[{\"args\":[[\"city\",\"in\",\"wuhan\",\"shanghai\"]],\"operator\":\"any\"}],\"operator\":\"all\"}";
        Expression expression = JSONObject.parseObject(expr, Expression.class);
        ESQuery<User> esQuery = new ESQuery<>();
        NativeSearchQueryBuilder queryBuilder = esQuery.buildQueryCondition(expression);
        NativeSearchQuery build = queryBuilder.build();
        System.out.println(build);
    }

}