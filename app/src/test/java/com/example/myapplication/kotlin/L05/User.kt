package com.example.myapplication.kotlin.L05

import org.junit.Test

class User private constructor(name: String) {

    companion object {

        fun create(name: String): User {
            // 统一检查，比如敏感词过滤
            return User(name)
        }
    }


}