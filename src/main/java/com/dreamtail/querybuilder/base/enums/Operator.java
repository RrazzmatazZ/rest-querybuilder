package com.dreamtail.querybuilder.base.enums;

public enum Operator {
    ALL("all", "Returns `true` if all the inputs are `true`"),
    ANY("any", "Returns `true` if any the input is `true`");


    private final String code;
    private final String desc;

    Operator(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
