package com.example.kotlintest.grammer

/**
 * 测试list set map.
 */
fun main() {
    testList()
    testMap()
}

/**
 * 测试list，set与之类似
 */
fun testList() {
    val list = listOf(1, 7, 3, 8, 5, 6, 4, 2) //todo 只读list
    list.filter { it % 2 == 0 }.forEach { print(it) }//todo 过滤
    println()
    list.sorted().forEach { print(it) }//todo 排序
    println()
    list.map { it * it }
        .forEachIndexed { index, i -> println("index $index --- value $i") }//todo 映射

    println("有元素满足条件:" + list.any { it < 2 }) //todo
    println("所有元素满足条件:" + list.all { it < 9 })

    val listMutable = mutableListOf("问苍茫大地1", "谁主沉浮2", "独立寒秋3", "湘江北去4") //todo 可读可改
    listMutable.add("橘子洲头5")
    listMutable.forEach { println(it + "") }

    listMutable.forEach() {
        print(it)
    }

    //todo 怎么样用最原始的形式调用呢
    listMutable.YaforEach {

    }

    //var a = list.get(9)  //如果越界 会直接崩溃
    val b = list.getOrElse(9) { 0 } //越界时 提供默认安全值
    val c = list.getOrNull(9) //越界时 提供null
    println("b is $b,c is $c")

}

//模仿forEach
fun <T> Iterable<T>.YaforEach(we: (T) -> Unit): Unit {
    for (element in this) we(element)
}



/**
 * 指定类
 */
fun testInit() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

}

fun testMap() {
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.entries.forEach { println("$it") }
    println("map3:" + map[3])
    println("contain(c):" + map.values.contains("c"))

}