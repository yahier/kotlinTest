package com.example.kotlintest.grammer

/**
 * 测试 基础数据
 */
fun main(args: Array<String>) {
    test1()
}

/**
 * 数据赋值和转换
 */
fun test1() {
    var a: Byte = 1
    var b: Int = a.toInt()
    var name: String? = null
    if (name!!.isBlank()) {
        println("name is empty")
    }
}