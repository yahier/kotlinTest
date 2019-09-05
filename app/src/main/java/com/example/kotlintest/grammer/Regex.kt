package com.example.kotlintest.grammer

/**
 * 正则表达式的匹配
 */
fun main() {
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))
    testMatch()
}

fun testMatch() {
    val regex = "^1\\d{10}".toRegex()//1开头的11位数字
    val validPhone = regex.matches("01152017573") //是否匹配
    println("validPhone is $validPhone")

    val result: MatchResult? = regex.find("1852013754019") //寻找匹配内容
    println("result is ${result?.value}")

    val result2 = regex.replace("18520137573008","")//替换匹配内容
    println("result2 is $result2")
}