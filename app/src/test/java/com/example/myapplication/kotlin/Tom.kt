package com.example.myapplication.kotlin

class Tom(canFly: Boolean): Behavior {

    override val canWalk: Boolean = true

    var canFly = canFly

    init {
        print("haha")
    }

    var canFly2 = canFly

}