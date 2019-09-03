package com.example.kotlintest.grammer

/**
 * 注意集成抽象类的结构顺序
 */
class Rectangle(override var width: Double, override var height: Double, override var radius: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }


    override fun describe() {
        println("子类重新描述")
    }


}

fun main() {
    val rectangle = Rectangle(4.0, 3.0, 5.0)
    val area = rectangle.area()
    print("area is $area")
    rectangle.onClick()
    rectangle.describe()

    //伴生对象 主从构造
    val instance = Sheldom.create(24)
    instance.name = "子旺"
    println(instance.name + " " + instance.age)
    val sheldon2 = Sheldom("panny")
    println(sheldon2.name + " " + sheldon2.age)
}