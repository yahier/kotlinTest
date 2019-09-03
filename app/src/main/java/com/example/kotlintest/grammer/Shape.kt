package com.example.kotlintest.grammer

abstract class Shape {
    abstract var width: Double
    abstract var height: Double
    abstract var radius: Double
    abstract fun area(): Double

    fun onClick(){
        print("在shape上onClick")
    }

    /**
     * 允许被子类重写的方法 需要加open关键字
     */
    open fun describe(){
        print("描述了一下 ")
    }
}