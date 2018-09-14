package com.designpatterns.buildermethod.sorter;

import com.designpatterns.buildermethod.collection.LinkedList;
import com.designpatterns.buildermethod.collection.MyLinkedList;
import com.designpatterns.buildermethod.collection.Node;
import com.designpatterns.buildermethod.comparetor.Comparetor;


public class FastSorter<T> extends Sorter<T> {
    public void sort(LinkedList<T> linkedList, Comparetor<T> comparetor){
        System.out.println("----快速排序----");
        LinkedList result=fastSort(linkedList,comparetor);
        linkedList.setHead(result.getHead());
        linkedList.setTail(result.getTail());
    }

    public LinkedList<T> fastSort(LinkedList<T> linkedList, Comparetor<T> comparetor){
        if(linkedList.getHead()==linkedList.getTail()) return linkedList;
        LinkedList<T> myLinkedList=new MyLinkedList<T>();
        LinkedList left=new MyLinkedList();
        LinkedList right=new MyLinkedList();
        LinkedList result=new MyLinkedList();

        Node medium=linkedList.getHead();
        Node n=linkedList.getHead();
        do{
            n=n.getNext();
            if(comparetor.compare((T)n.getValue(),(T)medium.getValue())<0)
                left.addNode(n);
            else
                right.addNode(n);
        }while(n!=linkedList.getTail());

        if(left.getHead() != null){
            left=fastSort(left,comparetor);
            left.getTail().setNext(medium);
            result.setHead(left.getHead());
        }
        else
            result.setHead(medium);

        if(right.getHead() != null) {
            right=fastSort(right,comparetor);
            medium.setNext(right.getHead());
            result.setTail(right.getTail());
        }
        else
            result.setTail(medium);
        return result;
    }
}