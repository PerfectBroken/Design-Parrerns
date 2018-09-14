package com.designpatterns.factorymethod.Product;

public class C extends Code{
    public C(){
        name="C语言";
    }
    public void descript(){
        System.out.println(getName()+":我是面向过程的，性能很棒，可读性很差~");
    }
}