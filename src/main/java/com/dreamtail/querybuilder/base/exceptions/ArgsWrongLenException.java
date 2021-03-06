package com.dreamtail.querybuilder.base.exceptions;

/**
 * @author xdq
 * @version 1.0
 * @className ArgsWrongLenException
 * @description 参数长度错误
 * @date 2021/7/26 11:13
 */
public class ArgsWrongLenException extends RuntimeException {

    public ArgsWrongLenException(String msg) {
        super(msg);
    }
}
