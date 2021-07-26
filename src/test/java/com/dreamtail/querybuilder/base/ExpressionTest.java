package com.dreamtail.querybuilder.base;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExpressionTest {


    @Test
    public void buildQueryCondition() {
        Expression expression = new Expression();
        expression.setOperator("all");
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"age", "gt", "20"});
        list.add(new String[]{"name", "like", "john"});
        expression.setArgs(list);
        String s = JSON.toJSONString(expression);
        System.out.println(s);
    }

    @Test
    public void buildQueryConditionWithChild() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"age", "gt", "20"});
        list.add(new String[]{"name", "like", "john"});

        List<String[]> list1 = new ArrayList<>();
        list1.add(new String[]{"city", "in", "wuhan", "shanghai"});
        Expression expChild = new Expression()
                .setOperator("any")
                .setArgs(list1);

        Expression expression = new Expression()
                .setOperator("all")
                .setArgs(list)
                .setChild(new Expression[]{expChild});
        String s = JSON.toJSONString(expression);
        System.out.println(s);
    }


}