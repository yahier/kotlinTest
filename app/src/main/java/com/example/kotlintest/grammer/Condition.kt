package com.example.kotlintest.grammer

/**
 * 测试 条件控制
 */
fun main(args: Array<String>) {
    var sheldom = Person("copper")
    var raxi = Person("raxi", false)
    var amy = Person(24)
    //println(amy.age)
    //testFor()

    var a = 1.5
    testIf(12)

    print("haha "+a.inc())

}


fun testFor() {
    for (i in 0 until 3) {
        println("i is " + i)
    }
    println()

    //递减 一次跳两个
    for (i in 20 downTo 10 step 2) {
        println(i)
    }
}

fun testIf(a: Int): Int {
    val i = if (a > 100) a else 100
    return i
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