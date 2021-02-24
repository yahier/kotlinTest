package com.example.kotlintest.bean;

public interface Shop<T> {
    void showFruitName(T t);

    T getFruit();
}

