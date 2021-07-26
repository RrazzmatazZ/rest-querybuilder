package com.dreamtail.querybuilder.support;

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
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"age", "gt", "20"});
        list.add(new String[]{"name", "like", "john"});

        List<String[]> list1 = new ArrayList<>();
        list1.add(new String[]{"city", "in", "wuhan", "shanghai"});
        list1.add(new String[]{"city", "in", "wuhan", "shanghai"});
        Expression expChild = new Expression()
                .setOperator("all")
                .setArgs(list1);

        Expression expression = new Expression()
                .setOperator("any")
                .setArgs(list)
                .setChild(new Expression[]{expChild})
                ;

        MybatisQuery<User> mybatisQuery = new MybatisQuery<>();
        QueryWrapper<User> queryWrapper = mybatisQuery.buildQueryCondition(expression);
        userDao.selectList(queryWrapper);
    }
}