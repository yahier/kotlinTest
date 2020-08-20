package com.example.kotlintest.grammer

/**
 * kotlin语言层面上地支持的代理模式
 */
interface Buyer{
    fun buyCoach()

    fun buyGucci()
}

class XiaoMing : Buyer{
    override fun buyCoach() {
        println("XiaoMing buy Coach!")
    }

    override fun buyGucci() {
        println("XiaoMing buy Gucci!")
    }
}

class XiaoHong(val realBuyer: Buyer) : Buyer by realBuyer {

    override fun buyCoach() {
        println("Brother, please buy Coach for me.")
        realBuyer.buyCoach()
        println("Thanks Brother, I will give some money to you.")
    }

    override fun buyGucci() {
        println("Brother, please buy Gucci for me.")
        realBuyer.buyGucci()
        println("Thanks Brother, I will give some money to you.")
    }

}

fun main(args: Array<String>) {
    val xiaoHong = XiaoHong(XiaoMing())
    xiaoHong.buyCoach()
    xiaoHong.buyGucci()
}