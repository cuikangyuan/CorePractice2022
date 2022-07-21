package com.example.myapplication.kotlin.L05

class UserMgr5 private constructor(name: String) {

   companion object : ISingleton<String, UserMgr5> {
       override fun creator(param: String): UserMgr5 = UserMgr5("name")

       @Volatile override var instance: UserMgr5? = null
   }
}