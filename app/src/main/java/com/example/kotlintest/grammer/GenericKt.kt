package com.example.kotlintest.grammer

import com.example.kotlintest.bean.Apple
import com.example.kotlintest.bean.Fruit
import com.example.kotlintest.bean.Shop

class GenericKt {
    fun test1(){
        //关键字 out 来支持协变，等同于 Java 中的上界通配符 ? extends
        val appleShop: Shop<out Fruit>// Shop<? extends Fruit> appleShop;


        //使用关键字 in 来支持逆变，等同于 Java 中的下界通配符 ? super
        val fruitShop: Shop<in Apple> //Shop<? super Apple> fruitShop;
    }



}



//用where实现多个上限 ，参考GenericType类的java写法
class PetShop<T>(val t: T) where  T : Fruit?, T : java.io.Serializable{

}