package com.designpatterns.buildermethod.comparetor;

public abstract class Comparetor<T> {
    /*
    升序排序 objectLeft<objectRight返回-1
     */
    public abstract byte compare(T objectLeft,T objectRight);
}