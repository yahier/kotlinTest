package com.example.kotlintest.grammer

fun main() {
    testLet()

}

fun testLet() {
    println("testLet被调用")
    val name: String? = null

     name?.let {
        println("name is $name")
    }

    name?.run {
        println("testLet run..$name")
    }

//    lateinit var place:String
//    place.let {
//        println("place is $place")
//    }
}