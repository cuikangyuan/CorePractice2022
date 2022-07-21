package com.example.myapplication.kotlin.L05

//伴生对象 Double Check
class UserMgr3 private constructor(name: String) {
    companion object {
        @Volatile
        private var INSTANCE: UserMgr3? = null
        fun getInstance(name: String): UserMgr3 =
            // 第一次判空
            INSTANCE ?: synchronized(this) {
                // 第二次判空
                INSTANCE ?: UserMgr3(name).also { INSTANCE = it }
            }
    }
}