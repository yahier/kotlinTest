package com.example.kotlintest.library

import android.util.Log

fun main() {
    val test = CollectionTest()
    test.sort()
}

class CollectionTest {

    fun sort() {
        val list = listOf(1, 7, 3, 8, 5, 6, 4, 2)
        //看源代码明白了这个方法的意思
        val listNew = list.sortedBy {
            it
        }
        listNew.stream().forEach {
            println("$it")
        }

    }


    /**
     * mark 将一个声明标记为平台相关，并期待在平台模块中实现
     * 方法实现，转移到了java包下的ArrayList
     */
    fun arrayList() {
        val list = ArrayList<String>()
        val size = list.size

    }
}