package com.example.myapplication.kotlin.L05

//Kotlin 编译器会将其转换成静态代码块的单例模式
object UserMgr {
    fun login() {
        print("login")
    }
}