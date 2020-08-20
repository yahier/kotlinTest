package yahier.com.myapplication.grammer

import java.util.*

fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数
    println("Hello World!")         // 分号可以省略
    println(Arrays.toString(args))

    //lambda表达式
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(1, 2))  // 输出 3

    set()
    testArray()
}

val haifei: Int = 24
val userName: String = "yahier"

/**
 * 赋值
 */
fun set() {
    val a = 4  //常量 自动推断类型
    var b = 5  //变量

    lateinit var str: String
    println(a + haifei)

    println("Name:$userName")
}

/**
 *数组
 */
fun testArray() {
    //用这种方式定义的数组，所有元素都是ya
    val array = Array(5) { "ya" }
    for (a in array) {
        println(a)
    }

    var intArray: IntArray = intArrayOf(1, 2, 3)
    val stringArray = arrayOf("a", "b", "c")

    for (i in 0..2) {
        println(stringArray[i] + intArray[i])
    }

}


/**
 *
Kotlin uses == for structural comparison and === for referential comparison.
More precisely, a == b compiles down to a == null ? b == null : a.equals(b).
 */
fun testCompairson() {
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)   // true because it calls authors.equals(writers) and sets ignore element order.
    println(authors === writers)  // false because authors and writers are distinct references.
}

