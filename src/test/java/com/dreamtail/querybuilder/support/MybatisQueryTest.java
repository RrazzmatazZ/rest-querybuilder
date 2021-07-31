package com.dreamtail.querybuilder.support;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamtail.querybuilder.base.Expression;
import com.dreamtail.querybuilder.examples.User;
import com.dreamtail.querybuilder.examples.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisQueryTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testBuildMybatisQuery() throws Exception {
        String expr = "{\"args\":[[\"age\",\"gt\",\"20\"],[\"name\",\"like\",\"john\"]],\"child\":[{\"args\":[[\"city\",\"in\",\"wuhan\",\"shanghai\"]],\"operator\":\"any\"}],\"operator\":\"all\"}";
        Expression expression = JSONObject.parseObject(expr, Expression.class);
        MybatisQuery<User> mybatisQuery = new MybatisQuery<>(User.class);
        QueryWrapper<User> queryWrapper = mybatisQuery.buildQueryCondition(expression);
        userDao.selectList(queryWrapper);
    }
}
