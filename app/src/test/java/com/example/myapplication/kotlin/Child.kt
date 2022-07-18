package com.example.myapplication.kotlin

class Child(age: Int){
    var age = age
    set(value) {
        if (value >= 18) {
            field = 18
        } else {
            field = value
        }
    }
}