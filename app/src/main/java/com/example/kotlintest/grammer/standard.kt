package com.example.kotlintest.grammer

/**
 * 测试标准方法  参考Standard.kt  在kotlin-stdlib-common下
 */
private fun main() {
    //testRun()
    //testWith()
    //testLet()
    testApply()
    testAlso()
    //takeUnless()
    //testRepeat()
}


private fun testRun() {
    var name = "bingo"
    var width: Int? = null

    name = width.run {
        "无所谓吗"
    }
    println("name is $name")

    // 也可以返回另外一个数据喔
    val age = 18
    val color = age.run {
        "黑色 ${this}"
    }
    println("color is $color")
}


private fun testTodo() {
    //todo 我是注释里面的
    TODO("我就写在外面 怎么了") // kotlin.NotImplementedError
}

private fun testWith() {
    val hobby = "drive"
    val hobby2: String? = null
    //参数为空，方法体继续执行
    val age = with(hobby2) {
        println("i want to drive across the city")
        18
    }

    println("age is $age")
}


private fun testApply() {
    val king = "王"
    king.apply {
        println("apply king is ${king}")
    }
}

private fun testAlso() {
    val king = "王"
    king.also {
        println("also king is ${king}")
    }
}

private fun testLet() {
    var name = "bingo"
    var width: Int? = null
    //前者为空，不执行方法体
    width?.let {
        println("let 天府")
        90
    }
}

/**
 * 条件满足，返回自身，否则null
 */
private fun takeIf() {
    var name: String? = "bingo"
    name = name.takeIf {
        it?.length == 4
    }
    println("name is $name")
}

/**
 * 与上面的takeIf相反
 */
private fun takeUnless() {
    var name: String? = "bingo"
    name = name.takeUnless {
        it?.length == 4
    }
    println("name is $name")
}


private fun testRepeat() {
    val list = listOf(1, 2, 3, "String")
    repeat(list.size) {
        print(" repeat 缩写方式 " + list[it])
    }

    println()

    repeat(list.size, { a ->
        print(" repeat 原始体 " + list[a])
    })
}








