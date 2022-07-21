package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {


    fun func1() {
        print("func1")
        func2()
    }

    inline fun func2() {
        print("func2")
        func3()
    }


    inline fun func3() {
        print("func3")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        hh(1)
//        hh(1, 3)
//
//        var list = listOf(3, 1)
//
//
//        var user1: User? = User("haha", 1)
//        var user2: User? = null
//
//        val haha = user2?.haha()
//
//        Log.d("MainActivity1", user2?.haha().toString())
//
//
//        var res = with(user1, {
//            this?.name
//            this?.age
//        })
//        Log.d("MainActivity1", " with res = $res")
//
//        var runRes = user1.run {
//            Log.d("MainActivity1", "run")
//        }
//
//        Log.d("MainActivity1", " run res = $runRes")
//
//        var applyRes = user1.apply {
//            Log.d("1", "1")
//        }
//
//
//        user1.also {
//            Log.d("1", "1")
//        }
//
//
//        user1.let {
//            Log.d("1", "1")
//        }
//
//
//        val rv = RecyclerView(this)
//        rv.layoutManager = LinearLayoutManager(this)
    }
}