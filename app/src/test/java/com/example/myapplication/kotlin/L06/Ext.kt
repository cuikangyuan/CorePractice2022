package com.example.myapplication.kotlin.L06
/*
 ①    ②      ③            ④
 ↓     ↓       ↓            ↓      */
fun String.lastElement(): Char? {
    //    ⑤
    //    ↓
    if (this.isEmpty()) {
        return null
    }
    return this[length - 1]
}