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

    lateinit var str:String
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

