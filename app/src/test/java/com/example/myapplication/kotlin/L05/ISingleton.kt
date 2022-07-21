package com.example.myapplication.kotlin.L05

interface ISingleton<P, T> {

    //instance 无法使用 private 修饰 instance 无法使用 @Volatile 修饰
    //单例“接口模板”并不是一种合格的实现方式。
    //
    var instance: T?

    fun creator(param: P): T

    fun getInstance(p: P): T =
        instance ?: synchronized(this) {
            instance ?: creator(p).also { instance = it }
        }
}