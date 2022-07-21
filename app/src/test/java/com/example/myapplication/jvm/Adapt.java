package com.example.myapplication.jvm;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Adapt {
    Class<?> value();
}
