package com.example.kotlintest.androidx

/**
 *   参考 https://developer.android.google.cn/reference/kotlin/androidx/core/text/package-summary?hl=zh_cn
 */

fun main() {
    testCharSequence()
}

fun testCharSequence() {
    val idNo: String = " "
    val isBlank = idNo.isBlank()  //true
    val isEmpty = idNo.isEmpty()  //false
    println("testCharsquence  $isBlank $isEmpty")
}

