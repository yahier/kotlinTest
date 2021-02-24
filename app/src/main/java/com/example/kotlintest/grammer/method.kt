package com.example.kotlintest.grammer

/**
 * 测试函数
 */
fun main() {
    test1()
    //todo
    test1(b = 4, a = 5) //具名传参

    asList(1, 2, 3)

    test2()

    doForever()
    println(sum1(1, 2))
    println(sum2(1, 2))
    println(sum3(1, 2))

    testFunc {
        println("你想干啥呢")
    }
}


fun testFunc(func: () -> Unit) {
    func()

}

/**
 * 参数有默认值
 */
fun test1(a: Int = 2, b: Int = 3) {
    println("a is $a,b is $b")
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
    println("test2:" + sum(2, 3))
}

fun doForever(): Unit {
    println("do something...")
}

/**
 * 单表达式函数可以简化为下面sum2 sum3
 */
fun sum1(x: Int = 0, y: Int): Int {
    return x + y
}

fun sum2(x: Int = 0, y: Int): Int = x + y

fun sum3(x: Int = 0, y: Int) = x + y

/**
 * 参数 可为空，设置默认值
 */
fun sum4(x: Int? = 8): Int? {
    return x?.plus(2)
}

