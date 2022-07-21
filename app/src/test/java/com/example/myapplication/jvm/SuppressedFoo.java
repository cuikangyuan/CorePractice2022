package com.example.myapplication.jvm;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuppressedFoo implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new RuntimeException(name);

    }

    private final String name;
    public SuppressedFoo(String name) { this.name = name; }


    @Test
    public void test() {
        Method method
                method.setAccessible();
        try (SuppressedFoo foo0 = new SuppressedFoo("Foo0"); // try-with-resources
             SuppressedFoo foo1 = new SuppressedFoo("Foo1");
             SuppressedFoo foo2 = new SuppressedFoo("Foo2")) {
            throw new RuntimeException("Initial");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * // 在同一 catch 代码块中捕获多种异常
    try {
    ...
    } catch (SomeException | OtherException e) {
    ...
    }
    *
    * */
}
