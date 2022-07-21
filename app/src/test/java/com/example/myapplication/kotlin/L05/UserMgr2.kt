package com.example.myapplication.kotlin.L05

//借助懒加载委托
object UserMgr2 {

    val user by lazy { loadUser() }

    private fun loadUser(): User {
        // 从网络或者数据库加载数据
        return User.create("tom")
    }

    fun login() {}
}