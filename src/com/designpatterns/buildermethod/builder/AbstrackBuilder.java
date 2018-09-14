package com.designpatterns.buildermethod.builder;

import com.designpatterns.buildermethod.collection.LinkedList;

import java.util.List;

public abstract class AbstrackBuilder<T> {
    public abstract void setSequence(Object[] sequenceList);
    public abstract LinkedList<T> getLinkedList();
}