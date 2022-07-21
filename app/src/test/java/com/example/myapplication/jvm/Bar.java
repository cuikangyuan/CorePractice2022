package com.example.myapplication.jvm;

public class Bar {
    @Adapt(IntBinaryOperator.class)
    public static int add(int a, int b) {
        return a + b;
    }
}
