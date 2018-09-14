package com.designpatterns.factorymethod.Product;

public class PHP extends Code {
    public PHP(){
        name="PHP";
    }
    public void descript(){
        System.out.println(getName()+":我是面向对象的，压力大时老崩溃，各种神奇的语法让人又爱又恨~~");
    }
}