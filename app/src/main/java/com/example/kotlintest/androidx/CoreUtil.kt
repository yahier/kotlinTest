package com.example.kotlintest.grammer.androidx

import androidx.core.util.Pools


/**
 * 对象池测试  参考 https://developer.android.google.cn/reference/kotlin/androidx/core/util/package-summary?hl=zh_cn
 */
fun main() {
    testPool()
    testPair()
}

/**
 * todo 很奇怪，怎么利用这个maxPoolSize, 看起来好像只保留一个对象，不需要这个size参数
 */
fun testPool() {
    val pool = Pools.SimplePool<String>(2)
    val name = pool.acquire()
    val result = pool.release("bingo")
    val result2 = pool.release("soso")
    val name2 = pool.acquire()
    println("pool $name $name2")
}

/**
 * 双参，有些方法的返回有两个数据，可以如此
 */
fun testPair() {
    val pair = Pair("燕儿", 18)
    println("pair  ${pair.first} ${pair.second}")
}