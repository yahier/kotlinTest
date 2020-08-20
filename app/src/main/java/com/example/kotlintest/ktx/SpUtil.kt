package com.example.kotlintest.ktx

import android.content.SharedPreferences
import androidx.core.content.edit as edit1

class SpUtil {
    lateinit var sharedPreferences: SharedPreferences

    init {
        //sharedPreferences
    }


    fun testPut(value: Boolean) {
        sharedPreferences.edit1 {
            putBoolean("key", value)
        }


    }
}

fun main() {
    println(123)
}