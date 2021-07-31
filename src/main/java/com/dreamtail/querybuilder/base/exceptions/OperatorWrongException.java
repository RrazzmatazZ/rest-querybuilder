package com.dreamtail.querybuilder.base.exceptions;

/**
 * @author xdq
 * @version 1.0
 * @className OperatorWrongException
 * @description 关系表达式错误
 * @date 2021/7/26 11:18
 */
public class OperatorWrongException extends RuntimeException {

    public OperatorWrongException(String msg) {
        super(msg);
    }
}
