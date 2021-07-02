package com.dreamtail.querybuilder.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamtail.querybuilder.base.Expression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MybatisQueryTest {

    @Test
    public void buildQueryCondition() {
        Expression expression = new Expression();
        expression.setOperator("and");
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"age", "gt", "20"});
        list.add(new String[]{"name", "like", "john"});
        expression.setArgs(list);
        String s = JSON.toJSONString(expression);
        System.out.println(s);
    }
}