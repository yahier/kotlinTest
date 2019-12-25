package com.example.kotlintest.grammer

/**
 * 类型 A.(B) -> C 表示可以在 A 的接收者对象上以一个 B 类型参数来调用并返回一个 C 类型值的函数。
 */
open class Hierfun<T> {


    fun double(x: Int): Int {
        return 2 * x
    }

    /**
     * 定义参数为一个方法
     */
    fun triple(double: (Int) -> Int): (Int) -> Int {
        return { x -> double(x) + x }
    }


}