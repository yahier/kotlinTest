package com.example.kotlintest.grammer

import android.util.Log
import kotlinx.coroutines.*
import java.io.File

/**
 * 测试 协程.   效果很奇怪，很多时候感觉完全没有执行.todo 协程的测试需要在Android的环境中
 */

fun main(args: Array<String>) {
    println("主 threadId:" + Thread.currentThread().id)
    println("测试协程 ")
    //fullParas()
    //lazyStart()
    test11()
}


fun test11() {
    //创建协程 注意  此方法实际上有三个参数滴

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    GlobalScope.launch {
        println("launch 协程开始运行1 ")
        doInCorountine()
    }.start()

    scope.launch {
        println("launch 协程开始运行2 ")
        doInCorountine()
    }

}

/**
 * 挂起的方法 只能从协程 或者其他挂起的方法调用
 */
suspend fun doInCorountine() {
    Thread.sleep(3000)
    println("threadId:" + Thread.currentThread().id)
    println("doInCorountine ")
    // withContext(Dispatchers.IO)
}


/**
 * 写上全参数
 */
fun fullParas() {
    //其中 第一个参数可以理解为协程的上下文 用调度模式的话 有这样四种
    //Dispatchers.Default
    //Dispatchers.IO -
    //Dispatchers.Main - 主线程
    //Dispatchers.Unconfined - 没指定，就是在当前线程

    //第二个参数是启动模式  默认即创建就启动
    GlobalScope.launch(Dispatchers.Default, CoroutineStart.DEFAULT) {
        doMuchTask()
    }

}

/**
 * 协程懒加载  为什么执行效果感觉很奇怪呢 经常无法调动呢
 */
fun lazyStart() {
    val job1: Job = GlobalScope.launch(start = CoroutineStart.DEFAULT) {
        println("job1 协程开始运行1 ")
    }

    //Thread.sleep(5000L)
    // 手动启动协程
    //job1.start()

//    val job2: Job = GlobalScope.launch(start = CoroutineStart.DEFAULT) {
//        println("job2 协程开始运行 ")
    //Thread.sleep(5000L)
    // println("job1 协程开始运行2 ")
//    }

    println("lazyStart 喝茶吧")

}


fun doMuchTask(): String {
    val time1 = System.currentTimeMillis()
    for (i in 0..10000) {
        val file = File("C:\\Users\\EDZ\\Desktop\\yahier.TXT")
        file.writeText("算命啦  你算什么东西\n配钥匙啦 你配几把\n")//覆盖写入
        file.appendText("有没有搞错啊 我是机器人？")//末尾追加
        file.readLines().forEach { println(it) }//读进列表
    }
    val time2 = System.currentTimeMillis()
    return (time2 - time1).toString()
}


