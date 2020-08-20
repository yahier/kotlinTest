package com.example.kotlintest.ktx

import androidx.collection.arraySetOf

class CollectionTest {

    fun test() {
        val combinedArraySet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6)
        print(combinedArraySet)
    }

}

fun main() {
    val test = CollectionTest()
    test.test()

}