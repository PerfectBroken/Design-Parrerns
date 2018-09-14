package com.designpatterns.buildermethod.comparetor;

public class IntegerDECComparetor<T extends Integer> extends  Comparetor<T>{
    public byte compare(T objectLeft,T objectRight){
        int a = (int) objectLeft;
        int b = (int) objectRight;
        if (a < b) return 1;
        else if (a > b) return -1;
        else return 0;
    }
}