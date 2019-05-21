package yahier.com.myapplication.grammer

/**
 * 创建类
 */
data class Customer(val name: String, val email: String)

fun cc() {
    var s = "bingo"
    var data = Customer("yahier", "ya@qq.com")
}

/**
 * 一般方法
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * if语句
 */
fun getMax(a: Int, b: Int) = if (a > b) a else b


/**
 * for循环
 */
fun forTest() {
    val items = listOf("apple", "banana", "kiwifruit")
//    if(items instanceOf List){
//
//    }
    for (item in items) {
        println(item)
    }

    for (i in 1..100) {
        //pass
    }

    val x = 10
    if (x in 1..10) {
        //pass
    }
}

/**
 * when
 */
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

