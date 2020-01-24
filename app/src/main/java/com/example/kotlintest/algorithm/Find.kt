package com.example.kotlintest.algorithm

class Find {
    val data = intArrayOf(1, 4, 5, 8, 9, 16, 20, 24)
    val key = 16


    fun findOne() {
        var index = data.size / 2
        while (key != data[index]) {
            if (key > data[index]) {
                index = (index + data.size) / 2
            } else {
                index /= 2
            }
        }
        println("找到了目标 index is $index")
    }


}


