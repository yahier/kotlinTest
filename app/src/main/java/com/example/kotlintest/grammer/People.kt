package com.example.kotlintest.grammer

open class Person public constructor(firstName: String) {
    var firstName: String
    var age: Int? = 0

    constructor(age: Int) : this("bingo") {
        this.age = age
    }

    init {
        println("People init")
        this.firstName = firstName
    }

}