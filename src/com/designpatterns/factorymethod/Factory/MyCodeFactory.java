package com.designpatterns.factorymethod.Factory;

import com.designpatterns.factorymethod.Product.Code;

public class MyCodeFactory extends AbstractCodeFactory {
    public <T extends Code> T createCode(Class<T> c) {
        T code = null;
        try {
            code = c.newInstance();
        } catch (Exception e) {
            System.out.print("工厂创建Code失败" + e.toString());
        }
        return code;
    }
}