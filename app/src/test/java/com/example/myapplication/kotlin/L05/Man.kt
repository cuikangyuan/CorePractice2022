package com.example.myapplication.kotlin.L05

abstract class Man {
    abstract fun findMan()
}

fun main() {
    // 这个匿名内部类，在继承了Man类的同时，还实现了A、B两个接口
    //种写法，在 Java 当中其实是不被支持的。
//    val item = object : Man(), A, B{
//        override fun funA() {
//            // do something
//        }
//        override fun funB() {
//            // do something
//        }
//        override fun findMan() {
//            // do something
//        }
//    }

    UserMgr.login()

}