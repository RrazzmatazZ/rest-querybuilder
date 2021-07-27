package com.dreamtail.querybuilder.base;

import com.dreamtail.querybuilder.base.enums.Comparison;
import com.dreamtail.querybuilder.base.enums.Operator;
import com.dreamtail.querybuilder.base.exceptions.ComparisonWrongException;
import com.dreamtail.querybuilder.base.exceptions.OperatorWrongException;

public abstract class BaseService<T> {

    protected abstract T buildQueryCondition(Expression searchModel) throws Exception;

    /**
     * 获取operator对应的枚举类型
     *
     * @param type operator String
     * @return Operator
     */
    protected Operator getOperator(String type) {
        for (Operator constants : Operator.values()) {
            if (constants.getCode().equals(type)) {
                return constants;
            }
        }
        throw new OperatorWrongException("wrong operator!");
    }

    /**
     * 获取Comparison对应的枚举类型
     *
     * @param type comparison String
     * @return Comparison
     */
    protected Comparison getComparison(String type) {
        for (Comparison constants : Comparison.values()) {
            if (constants.getCode().equals(type)) {
                return constants;
            }
        }
        throw new ComparisonWrongException("wrong comparison!");
    }

    /**
     * todo 判断param是否在查询类M的param中
     *
     * @param param 参数名称param
     */
    protected void checkQueryParam(String param) {

    }

    /**
     * 驼峰转下划线
     *
     * @param hump 驼峰字符串
     * @return String 下划线字符串
     */
    protected String toUnderline(String hump) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < hump.length(); ++i) {
            char ch = hump.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char u_case = (char) (ch + 32);
                if (i > 0) {
                    buf.append('_');
                }
                buf.append(u_case);
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

}
