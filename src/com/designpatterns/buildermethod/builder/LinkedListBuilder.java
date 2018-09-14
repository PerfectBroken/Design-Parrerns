package com.designpatterns.buildermethod.builder;

import com.designpatterns.buildermethod.collection.LinkedList;
import com.designpatterns.buildermethod.collection.MyLinkedList;
import com.designpatterns.buildermethod.comparetor.Comparetor;
import com.designpatterns.buildermethod.sorter.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListBuilder<T> extends AbstrackBuilder{
    private List<Object> sequence;

    public void setSequence(Object[] sequenceList){
        this.sequence= Arrays.asList(sequenceList);
    }

    public LinkedList<T> getLinkedList(){
        MyLinkedList<T> linkedList=new MyLinkedList<T>();

        for(Object object : sequence){
            if(object.getClass().getName().indexOf("Sorter")>0){
                linkedList.setSort((Sorter<T>)object);
            }
            if(object.getClass().getName().indexOf("Comparetor")>0){
                linkedList.setComparetor((Comparetor<T>) object);
            }
        }
        return linkedList;
    }

}