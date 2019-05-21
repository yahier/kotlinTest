package com.example.kotlintest.grammer

/**
 * 测试函数
 */
fun main(args: Array<String>) {
    test1()
    test1(4)

    asList(1, 2, 3)

    test2()
}

/**
 * 参数有默认值
 */
fun test1(a: Int = 2) {
    println(a)
}

/**
 * 可变参数
 */
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

/**
 * 局部函数
 */
fun test2() {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    println("test2:"+sum(2, 3))
}