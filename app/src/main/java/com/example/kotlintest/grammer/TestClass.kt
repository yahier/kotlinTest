package com.example.kotlintest.grammer

import android.view.View

/**
Kotlin 的对象声明是定义单例的一种方式，是延迟初始化的。
Kotlin 的对象表达式可以用来替代 Java 的匿名内部类，是实时创建的。
Kotlin 的伴生对象可以用来替代 Java 的静态属性和静态方法，是在伴生对象所在类加载时初始化的。
 */
fun main() {
    Singleton.printlnHelloWorld()
    testAy()
    println("mark1 is " + (Student.marks))
    Student.changeMarks("B")
    println("mark2 is " + (Student.marks))

    var color = Color.BLUE
    println("color信息 " + color.colorName + "" + color.ordinal)
}

/**
 * 匿名内部类
 */
fun testAy() {
    val view: View? = null
    view?.setOnClickListener {
        //pass
    }
    view?.setOnClickListener {
        //pass
    }
    var a: Int = 12
    if (a == 9) print(12)

    //为什么不能缩写呢
    setGoListener(object : GoListener {
        override fun onGo() {

        }
    })
}

fun setGoListener(listener: GoListener) {
    listener.onGo()
}


interface GoListener {
    fun onGo()
}

class Outter {
    val str1: String = "this property is from outter1 class"

    /**
     *  嵌套类不能访问外部类的属性
     */
    class Nested {
        var str2 = "bingo"
        fun foo() = println("$str2")
    }
}


class Outter2 {
    val str: String = "this property is from outter2 class"

    /**
     * inner关键字 内部类 可以访问外部类的的属性
     */
    inner class Inner {
        fun foo() = println("$str")
        var a: Int = 0
    }
}

/**
 * 枚举
 */
enum class Color constructor(var colorName: String, var value: Int) {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLUE("蓝色", 3)
}


enum class State {
    IDLE, RUNNING, FINISHED                           // 1
}


fun testEnumState() {
    val state = State.RUNNING                         // 2
    val message = when (state) {                      // 3
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)
}


/**
 * dayRates 对象表达式
 */
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    /**
     * point
     */
    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total")                                               //4

}


/**
 * 对象申明，实现单例模式
 */
object Singleton {
    fun printlnHelloWorld() = println("Singleton1 hello world")
}


/**
 * 测试 伴生对象.达成java的静态方法和属性
 */
class Student {
    /**
     * todo 伴生对象的成员类似于 Java 的静态成员
     */
    companion object {
        @JvmField //此关键字允许java使用此静态属性
        public var username = "Tony"
        public var marks = "A"

        @JvmStatic //此关键字允许java使用此静态方法
        fun printMarks() = "The ${this.username}'s mark is ${this.marks}"

        fun changeMarks(marks: String) {
            this.marks = marks
        }
    }
}

/**
 * todo 数据类使用data来装饰
 * 会自动生成以下方法
 * equals()/hashCode()方法  toString()方法 componentN()方法 copy()方法
 */
data class User(var name: String, var password: String)


/**
 * 密封类
 */
sealed class Mammal(val name: String)

class Dog(dogName: String) : Mammal(dogName)
class Horse(horseName: String) : Mammal(horseName)
class Human(humanName: String, val job: String) : Mammal(humanName)


fun greetMammal(mammal: Mammal) = when (mammal) {
    is Dog -> "Hello ${mammal.name}"
    is Horse -> "Hello ${mammal.name}"
    is Human -> "Hello ${mammal.name}, You're working as a ${mammal.job}"
}
