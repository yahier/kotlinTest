package com.example.kotlintest.grammer

import java.io.File

/**
 *kotlin扩展了java File类，读写操作大大的简洁
 * 同样扩展了正则表达式 Pattern
 */


fun main() {
    testFile()
    testThread()
    testThread2()
}

/**
 * 测试文件读写
 */
fun testFile() {
    val file = File("C:\\Users\\EDZ\\Documents\\WeChat Files\\yahier\\FileStorage\\File\\2019-09\\love2.TXT")
    file.writeText("算命啦  你算什么东西\n配钥匙啦 你配几把\n")//覆盖写入
    file.appendText("有没有搞错啊 我是机器人？")//末尾追加
    file.readLines().forEach { println(it) }//读进列表
}

fun testThread() = object : Thread() {
    var str: String? = "bingo"

    //str = ""
    //println("why 这里编译错误$str")
    init {
        println("init1 $str")
        sleep(1000)
        str = "yahier"
        println("init2 $str")
    }
}.start()


fun testThread2() {
    Thread {
        println("testThread2 1")
        Thread.sleep(1000)
        println("testThread2 2")
    }.start()
}