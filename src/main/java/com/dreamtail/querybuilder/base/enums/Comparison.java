package com.dreamtail.querybuilder.base.enums;

public enum Comparison {
    GT("gt", "> greater than"),
    LT("lt", "< less than"),
    GTE("gte", ">= greater than equal"),
    LTE("lte", "<= less than equal"),
    EQ("eq", "= equal"),
    NEG("neq", "!= not equal"),
    LIKE("like", "like");


    private final String code;
    private final String desc;

    Comparison(String code, String desc) {
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
