package com.example.myapplication.kotlin


sealed class Result {

    data class Success(val message: String = "") : Result()

    data class Error(val exception: Exception) : Result()

    data class Loading(val time: Long = System.currentTimeMillis()) : Result()
}
