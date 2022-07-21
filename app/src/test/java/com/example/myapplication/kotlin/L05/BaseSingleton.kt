package com.example.myapplication.kotlin.L05

abstract class BaseSingleton<in P, out T> {
    @Volatile
    private var instance: T? = null

    protected abstract fun creator(param: P): T

    fun getInstance(param: P): T =
        instance ?: synchronized(this) {
            instance ?: creator(param).also { instance = it }
        }
}