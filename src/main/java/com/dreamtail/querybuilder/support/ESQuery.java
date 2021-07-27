package com.dreamtail.querybuilder.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamtail.querybuilder.base.BaseService;
import com.dreamtail.querybuilder.base.Expression;

/**
 * @author xdq
 * @version 1.0
 * @className ESQuery
 * @description TODO
 * @date 2021/7/2 13:54
 */
public class ESQuery<M> extends BaseService<QueryWrapper<M>> {

    @Override
    protected QueryWrapper<M> buildQueryCondition(Expression searchModel) throws Exception {

        return null;
    }
}