package com.example.myapplication.kotlin.L05

class UserMgr4 private constructor(name: String) {

   companion object : BaseSingleton<String, UserMgr4>() {
       override fun creator(param: String): UserMgr4 = UserMgr4("name")
   }
}