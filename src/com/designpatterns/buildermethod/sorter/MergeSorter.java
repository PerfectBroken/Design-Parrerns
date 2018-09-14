package com.designpatterns.buildermethod.sorter;

import com.designpatterns.buildermethod.collection.LinkedList;
import com.designpatterns.buildermethod.collection.MyLinkedList;
import com.designpatterns.buildermethod.collection.Node;
import com.designpatterns.buildermethod.comparetor.Comparetor;

import java.util.ArrayList;

public class MergeSorter<T> extends Sorter<T> {
    public void sort(LinkedList<T> linkedList, Comparetor<T> comparetor){
        System.out.println("----归并排序----");
        ArrayList<LinkedList> list=new ArrayList<>();
        Node node=linkedList.getHead();
        Node nextNode;
        Node firstNode=linkedList.getHead();
        while(node.getNext()!=null){
            boolean flag=false;
            if(comparetor.compare((T)node.getValue(),(T)node.getNext().getValue())<0) {
                MyLinkedList l = new MyLinkedList();
                l.setHead(firstNode);
                l.setTail(node);
                firstNode=node.getNext();
                flag=true;
                l.getTail().setNext(null);
                list.add(l);
            }
            node = flag?firstNode:node.getNext();
        }
        //处理最后一个子集 当firstNode=node时正好结束，否则要从firtNode遍历到tail加入到list
        MyLinkedList l = new MyLinkedList();
        l.setHead(firstNode);
        if(firstNode!=node){
            while (firstNode.getNext()!=null){
                firstNode=firstNode.getNext();
            }
            l.setTail(firstNode);
        }
        else {
            l.setTail(firstNode);
        }
        l.getTail().setNext(null);
        list.add(l);
        nestedMergeSort(linkedList,list,comparetor);
    }

    public void nestedMergeSort(LinkedList<T> linkedList,ArrayList<LinkedList> list, Comparetor<T> comparetor){
        if(list.size()>1) {
            ArrayList<LinkedList> result = new ArrayList<>();
            LinkedList one = new MyLinkedList();
            LinkedList two = new MyLinkedList();
            //flag为真是one,two为两个相邻的子链表，进行归并
            boolean flag = false;
            for (LinkedList l : list) {
                if (flag) {
                    two = l;
                    result.add(mergeList(one, two,comparetor));
                } else one = l;
                flag = !flag;
            }
            list=null;
            if(flag) result.add(one);
            nestedMergeSort(linkedList,result,comparetor);
        }
        else{
            linkedList.setHead(list.get(0).getHead());
            linkedList.setTail(list.get(0).getTail());
        }
    }

    private LinkedList mergeList(LinkedList a,LinkedList b,Comparetor<T> comparetor){
        MyLinkedList result = new MyLinkedList();
        while (a.getHead() != null && b.getHead() != null) {
            if (comparetor.compare((T) a.getHead().getValue(), (T) b.getHead().getValue()) < 0) {
                mergeNode(a, result);
            } else {
                mergeNode(b, result);
            }
        }

        if (a.getHead() == null) {
            mergeEnd(b, result);
        } else if (b.getHead() == null) {
            mergeEnd(a, result);
        }
        return result;
    }

    private void mergeNode(LinkedList a,LinkedList result){
        Node node=a.getHead();
        a.setHead(a.getHead().getNext());
        result.addNode(node);
    }

    private void mergeEnd(LinkedList a,LinkedList result){
        result.getTail().setNext(a.getHead());
        result.setTail(a.getTail());
        a.setHead(null);
    }
}