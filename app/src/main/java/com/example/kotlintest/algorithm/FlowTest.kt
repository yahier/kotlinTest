package com.example.kotlintest.algorithm

import kotlinx.coroutines.delay


//参考 https://blog.csdn.net/vitaviva/article/details/104103958

class FlowTest {


    suspend fun foo(): List<Int> {
        delay(1000) // pretend we are doing something asynchronous here
        return listOf(1, 2, 3)
    }



    fun test1() {


    }
}