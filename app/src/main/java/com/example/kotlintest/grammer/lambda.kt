package com.example.kotlintest.grammer

/**
 * 测试 函数作为参数  参考 http://ddrv.cn/a/594638
 */
fun main() {
    action2 {
        it == 2
    }

    //todo 还可以进一步还原成更早的模样吗
    action1(1, {
        it % 2 == 1
    })


    val func1: (Int) -> Boolean = {
        true
    }


    fun func2(call: (Int) -> Boolean): Boolean {
        val value = call
        return true
    }

    //todo 这是我想要的最初的模样之一
    action1(2, func1)


    logDebug {
        "你想干什么"
    }

    logDebug() {
        "去哪里呢"
    }
}

fun invoke() {
    test2 {
        return@test2 it * 4
    }
}

private fun test0(x: Int): Int {
    return 2 * x
}

/**
 * 定义参数为一个方法
 */
private fun test2(funX: (Int) -> Int): Int {
    val value = funX(2)
    return value + 1
}

/**
 * 形式非常严格 ()和return中的{}都不能省略
 */
fun test3(): (Int) -> Int {
    return { x -> x }
}


/**
 * 定义参数为一个方法
 */
fun test4(funX: (Int) -> Int): (Int) -> Int {
    return { x -> funX(x) + x }
}


fun test(): String {
    return "你想干什么"
}


fun action1(first: Int, callback: (Int) -> Boolean) {
    //调用
    if (callback(first)) {
        println("回调函数返回值 true")
    } else {
        println("回调函数返回值 false")
    }
}

/**
 * 此方法接收一个返回String类型的方法
 */
private fun logDebug(method: (Int) -> String) {
    println(method)
}


fun action2(callback: (Int) -> Boolean): Unit {
    //调用
    if (callback(1)) {
        println("回调函数返回值 true")
    } else {
        println("回调函数返回值 false")
    }
}