package com.designpatterns.factorymethod;

import com.designpatterns.factorymethod.Factory.AbstractCodeFactory;
import com.designpatterns.factorymethod.Factory.CodeFactory;
import com.designpatterns.factorymethod.Factory.MyCodeFactory;
import com.designpatterns.factorymethod.Product.*;

public class FactoryMethodClient {
    public static void main (String[] args){
        Code code=null;
//        AbstractCodeFactory factory=new MyCodeFactory();
        AbstractCodeFactory factory=new CodeFactory();
        code=factory.createCode(C.class);
        code.descript();
        code=factory.createCode(Java.class);
        code.descript();
        code=factory.createCode(PHP.class);
        code.descript();
        code=factory.createCode(Python.class);
        code.descript();
    }
}