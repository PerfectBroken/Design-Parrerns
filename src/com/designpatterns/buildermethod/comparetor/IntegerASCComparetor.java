package com.designpatterns.buildermethod.comparetor;

public class IntegerASCComparetor<T extends Integer> extends Comparetor<T>{
    public byte compare(T objectLeft,T objectRight){
        int a = objectLeft;
        int b = objectRight;
        if (a < b) return -1;
        else if (a > b) return 1;
        else return 0;
    }
}