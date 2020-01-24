package com.example.kotlintest.grammer

fun main() {
    count()

}

fun count() {
    val name = "saaas"
    println(name.count { it.equals('a') })
}