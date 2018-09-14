package com.designpatterns.factorymethod.Factory;

import com.designpatterns.factorymethod.Product.Code;

public abstract class AbstractCodeFactory {
//    public abstract <T extends Code> T createCode(Class<T> c);
      public abstract <T extends Code> T createCode(Class<T> c);
}
