package com.example.myapplication.kotlin

import org.junit.Assert
import org.junit.Test

class A : Result {

    constructor():super()

    val a = 1
    var b = 2

    fun foo() = 1

    inner class B {
        val c = a
        val d = b
        val e = foo()
    }


    @Test
    fun display(data: Result) = when(data) {
        is Result.Success -> print("")
        is Result.Error -> print("")
        is Result.Loading -> print("")
        else -> print("")
    }

    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }
}