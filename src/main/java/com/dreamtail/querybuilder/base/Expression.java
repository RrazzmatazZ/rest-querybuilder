package com.dreamtail.querybuilder.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class Expression {

    private String operator;

    private List<String[]> args;

    private Expression[] child;
}

