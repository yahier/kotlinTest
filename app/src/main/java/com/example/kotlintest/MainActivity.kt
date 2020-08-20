package com.example.kotlintest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.arraySetOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testCollections()
    }

    /**
     * 测试ktx的集合
     */
    private fun testCollections() {
        val combinedArraySet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6)
        Log.e("MainActivity", "set直接想加后的数量是" + combinedArraySet.size)
    }
}
