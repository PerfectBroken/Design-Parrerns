package com.designpatterns.factorymethod.Product;

public class Python extends  Code {
    private static Python instance;
    static{
        instance=new Python();
    }
    private Python(){
        name="大Python";
    }

    public void descript(){
        System.out.println(getName()+":我是最近很受欢迎的大phthon，有胶水语言、黑客语言、科学语言等多种外号。");

    }

    public Python getInstance(){
        return instance;
    }
}