package com.dreamtail.querybuilder.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xdq
 * @version 1.0
 * @className Expression
 * @description Search Expression
 * @date 2021/7/2 14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expression {

    private String operator;

    private List<String[]> args;

    private Expression[] child;
}

