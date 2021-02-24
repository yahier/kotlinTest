package com.example.kotlintest.tools

import android.util.Range

public class RangeTest {
    fun test1() {
        val range = Range("aa", "bb")
        val isContained = range.contains("b")
        print("isContained is $isContained")
    }
}


public fun main() {
    val rangeTest = RangeTest()
    rangeTest.test1()

}