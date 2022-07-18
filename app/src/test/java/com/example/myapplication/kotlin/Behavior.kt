package com.example.myapplication.kotlin

interface Behavior {

    val canWalk: Boolean

    fun walk() {
        if (canWalk) {
            print("can walk $canWalk")
        } else {
            print("cannot walk $canWalk")
        }
    }
}