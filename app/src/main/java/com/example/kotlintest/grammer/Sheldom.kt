package com.example.kotlintest.grammer

/**
 * companion伴生对象
 */
class Sheldom(age: Int) : Person(age) {

    companion object Factory {
        fun create(age: Int): Sheldom = Sheldom(age)
    }

    val instance = Sheldom.create(24)
}