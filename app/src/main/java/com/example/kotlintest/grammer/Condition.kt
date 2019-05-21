package com.example.kotlintest.grammer

/**
 * 测试 条件控制
 */
fun main(args: Array<String>) {
    var sheldom = Person("copper")
    var amy = Person(24)
    println(amy.age)


}

fun testIf(a: Int): Int {
    return if (a > 10) 100 else 50
}

fun test2(x: Int) {
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }
}