package com.example.kotlintest.grammer

fun main() {
    testLet()

}

fun testLet() {
    println("testLet被调用")
    val name: String? = "bingo"

     name?.let {
        println("name is $name")
    }

    name?.run {
        println("testLet run..$this")
    }

    name.apply {
        println("我来自apply")
    }

//    lateinit var place:String
//    place.let {
//        println("place is $place")
//    }
}