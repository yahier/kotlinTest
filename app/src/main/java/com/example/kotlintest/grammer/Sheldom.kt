package com.example.kotlintest.grammer

/**
 * companion伴生对象
 */
class Sheldom(age: Int) : Person(age) {
    lateinit var name: String

    /**
     * 必须要实现主构造函数 记住这个语法
     */
    constructor(name: String) : this(20) {
        this.name = name
    }

    companion object Factory {
        fun create(age: Int): Sheldom = Sheldom(age)
    }


}