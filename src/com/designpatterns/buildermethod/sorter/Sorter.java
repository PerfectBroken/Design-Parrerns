package com.designpatterns.buildermethod.sorter;

import com.designpatterns.buildermethod.collection.LinkedList;
import com.designpatterns.buildermethod.comparetor.Comparetor;

public abstract class Sorter<T> {
    public abstract void sort(LinkedList<T> list,Comparetor<T> competitor);
}