package com.example.kotlintest.grammer;

import com.example.kotlintest.bean.Apple;
import com.example.kotlintest.bean.Fruit;
import com.example.kotlintest.bean.Shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型 参考GenericKt
 */
public class GenericType {


    /**
     * 上界通配符  ? extends
     */
    private void test1() {
        List<Apple> apples = new ArrayList<Apple>();
        List<? extends Fruit> fruits = apples;


        float weight = getTotalWeight(apples);
        getTotalWeight(fruits);
    }


    /**
     * 下限通配符 ? super
     */
    private void test2() {
        Shop<? super Apple> apples = new Shop<Fruit>() {
            @Override
            public void showFruitName(Fruit apple) {
            }

            @Override
            public Fruit getFruit() {
                return null;
            }
        };

        //本身也是包括的
        apples.showFruitName(new Apple());

        //编译失败
        //Apple apple = apples.getFruit();
    }


    private void test3(){
        Shop<? extends Fruit> appleShop;
        Shop<? super Apple> fruitShop;
    }


    private float getTotalWeight(List<? extends Fruit> fruitList) {
        float totalWeight = 0;
        for (Fruit fruit : fruitList) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }


    /**
     * 实现多个上界   参考GenericKt类的kotlin写法
     */
    class PetShop<T extends Fruit & Serializable> {
        //通过 & 实现了两个上界，必须是 Animal 和 Serializable 的子类或实现类
        private T t;

        PetShop(T t) {
            this.t = t;
        }
    }

}
