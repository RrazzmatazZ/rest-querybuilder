package com.dreamtail.querybuilder.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamtail.querybuilder.base.BaseService;
import com.dreamtail.querybuilder.base.Expression;
import com.dreamtail.querybuilder.base.enums.Operator;

/**
 * @author xdq
 * @version 1.0
 * @className MybatisQuery
 * @description TODO
 * @date 2021/7/2 13:54
 */
public class MybatisQuery<M> extends BaseService<QueryWrapper<M>> {

    @Override
    public QueryWrapper<M> buildQueryCondition(Expression expression) {
        QueryWrapper<M> queryWrapper = new QueryWrapper<>();
        Operator operator = this.getOperator(expression.getOperator());
        switch (operator) {
            case ALL:
                break;
            case ANY:
                break;
            default:
                break;
        }
        return queryWrapper;
    }
}