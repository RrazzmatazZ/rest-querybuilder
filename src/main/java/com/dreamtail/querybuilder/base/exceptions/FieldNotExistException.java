package com.dreamtail.querybuilder.base.exceptions;

/**
 * @author xdq
 * @version 1.0
 * @className ArgsWrongLenException
 * @description 类的参数对应错误
 * @date 2021/7/26 11:13
 */
public class FieldNotExistException extends RuntimeException {

    public FieldNotExistException(String msg) {
        super(msg);
    }
}
