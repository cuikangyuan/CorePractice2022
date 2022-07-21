package com.example.myapplication.kotlin.L05

import org.junit.Test

class Person {

//    object InnerSingleton {
//        //@JvmStatic
//        fun foo() {}
//    }

    companion object InnerSingleton {
        @JvmStatic
        fun foo() {}
    }


    fun main() {
        // Kotlin当中这样调用
        //Person.InnerSingleton.foo()
        //      等价
        //       ↓  java 当中这样调用
        //Person.InnerSingleton.INSTANCE.foo()
        Person.InnerSingleton.foo()
    }

    @Test
    fun test() {
        val user = User.create("haha")
        //val user = User("haha")
        UserMgr5.getInstance("11")
    }
}