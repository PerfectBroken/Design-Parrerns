package com.designpatterns.factorymethod.Product;

public class Java extends Code {
    public Java(){
        name="Java";
    }
    public void descript(){
        System.out.println(getName()+":我是面向对象的，性能还不错，可读性很棒~还开源呦 >w<~");
    }
}