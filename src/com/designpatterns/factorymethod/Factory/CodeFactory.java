package com.designpatterns.factorymethod.Factory;

import com.designpatterns.factorymethod.Product.Code;

public class CodeFactory extends AbstractCodeFactory {
    public <T extends Code> T createCode(Class<T> c) {
        T code = null;
        try {
            code = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("创建代码错误" + e.toString());
        }
        return code;
    }
}