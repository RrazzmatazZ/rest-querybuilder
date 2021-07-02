package com.dreamtail.querybuilder.base;

import com.dreamtail.querybuilder.base.enums.Comparison;
import com.dreamtail.querybuilder.base.enums.Operator;

public abstract class BaseService<T> {

    protected abstract T buildQueryCondition(Expression searchModel);

    protected Operator getOperator(String type) {
        for (Operator constants : Operator.values()) {
            if (constants.getCode().equals(type)) {
                return constants;
            }
        }
        return null;
    }

    protected Comparison getComparison(String type) {
        for (Comparison constants : Comparison.values()) {
            if (constants.getCode().equals(type)) {
                return constants;
            }
        }
        return null;
    }
}
