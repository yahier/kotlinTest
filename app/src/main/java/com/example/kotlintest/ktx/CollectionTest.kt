package com.example.kotlintest.ktx

import androidx.collection.arraySetOf
import com.example.kotlintest.grammer.Person
import kotlinx.coroutines.delay

class CollectionTest {

    fun test() {
        val combinedArraySet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6)
        print(combinedArraySet)
    }

    /**
     * 连接list中的某个属性
     */
    fun joinList() {
        val people = listOf(Person("Alice", true), Person("Bob", true))
        val names = people.joinToString(separator = "..",
            transform = { p: Person -> p.firstName })
        println(names)
    }


    fun matchTest() {
        val list = listOf(1, 2, 3)
        println(!list.all { it == 3 })
        println(list.any { it != 3 })
    }


    fun groupBy() {
        val list = listOf("a", "ab", "b")
        val map = list.groupBy(String::first) //得到的是map
        print(map)
    }

    fun flatMap() {
        val strings = listOf("abc", "def")
        println(strings.flatMap { it.toList() })
    }


    fun alphabet() {
        val result = StringBuilder()
        for (letter in 'A'..'Z') {
            result.append(letter)
        }
        result.append("\nNow I know the alphabet!")
        print(result.toString())
    }

    //with
    fun alphabet2() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }

    //apply
    fun alphabet3() = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }.toString()


    /**
     * 测试flow
     */
    fun flow(){
        floatArrayOf(1f,2f,3f,4f)

    }


    suspend fun foo():List<Int>{
        delay(3000)
        return listOf(1,2,3)
    }


}


fun main() {
    val test = CollectionTest()
    //test.test()
    //test.joinList()
    //test.groupBy()
    test.alphabet()

}