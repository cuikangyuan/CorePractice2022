package com.example.myapplication.kotlin

open class Person(val name: String, var age: Int){

    //wrong
    val isAdult = age >= 18

    //correct
//    val isAdult
//        get() = age >= 18

    open fun eat() {
        print("eat func")
    }

}