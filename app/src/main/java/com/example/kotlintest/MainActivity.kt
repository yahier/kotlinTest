package com.example.kotlintest

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.arraySetOf
import androidx.core.content.edit

/**
 * ktx list
 * https://developer.android.google.cn/kotlin/ktx/extensions-list
 */
class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)

        testCollections()
        testSp()
    }

    /**
     * 测试ktx的集合
     */
    private fun testCollections() {
        val combinedArraySet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6, 7)
        Log.e("MainActivity", "set直接想加后的数量是" + combinedArraySet.size)
    }

    private fun testSp() {
        sharedPreferences.edit {
            putString("name", "bingo")
        }
    }
}
