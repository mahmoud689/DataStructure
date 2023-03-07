package com.application.polishnotation;

import java.util.Arrays;

public enum Operator {
    plus("+"),
    division("/"),
    multiply("*"),
    minus("-");

    private final String text;

    Operator(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Operator from(String str) {
        return Arrays.stream(values()).filter(o -> o.text.equals(str)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
