//package com.designpatterns.buildermethod.collection;
//
//import java.util.ArrayList;
//
//public class MyLinkedList<T> extends LinkedList<T> {
//
//
//
//    public void sort(){
//        ArrayList<MyLinkedList> list=new ArrayList<>();
//        Node node=head;
//        Node nextNode;
//        Node firstNode=head;
//        while(node.getNext()!=null){
//            boolean flag=false;
//            if(node.getValue()<node.getNext().getValue()) {
//                MyLinkedList l = new MyLinkedList();
//                l.head = firstNode;
//                l.tail = node;
//                firstNode=node.getNext();
//                flag=true;
//                l.tail.setNext(null);
//                list.add(l);
//            }
//            node = flag?firstNode:node.getNext();
//        }
//        MyLinkedList l = new MyLinkedList();
//        l.head = firstNode;
//        if(firstNode!=node){
//            while (firstNode.getNext()!=null){
//                firstNode=firstNode.getNext();
//            }
//            l.tail=firstNode;
//        }
//        else l.tail=firstNode;
//        l.tail.setNext(null);
//        list.add(l);
//        nestedMergeSort(list);
//    }
//
//    public void nestedMergeSort(ArrayList<MyLinkedList> list){
//        if(list.size()>1) {
//            ArrayList<MyLinkedList> result = new ArrayList<>();
//            MyLinkedList one = new MyLinkedList();
//            MyLinkedList two;
//            boolean flag = false;
//            for (MyLinkedList l : list) {
//                if (flag) {
//                    two = l;
//                    result.add(mergeAggs(one, two));
//                } else one = l;
//                flag = !flag;
//            }
//            list=null;
//            if(flag) result.add(one);
//            nestedMergeSort(result);
//        }
//        else{
//            head=list.get(0).head;
//        }
//    }
//
//    private MyLinkedList mergeAggs(MyLinkedList a,MyLinkedList b){
//        MyLinkedList result=new MyLinkedList();
//        while(a.head!=null||b.head!=null){
//            if(a.head!=null&&b.head!=null){
//                if(a.head.getValue()>b.head.getValue()){
//                    mergeNode(a,result);
//                }
//                else{
//                    mergeNode(b,result);
//                }
//            }
//            else{
//                if(a.head==null) mergeEnd(b,result);
//                else if(b.head==null) mergeEnd(a,result);
//            }
//        }
//        return result;
//    }
//
//    private void mergeNode(MyLinkedList a,MyLinkedList result){
//        Node node;
//        if(result.head==null) {
//            result.head = a.head;
//            a.head = a.head.getNext();
//            result.tail=result.head;
//        }
//        else{
//            node=a.head;
//            a.head=a.head.getNext();
//            result.tail.setNext(node);
//            result.tail=node;
//        }
//    }
//
//    private void mergeEnd(MyLinkedList a,MyLinkedList result){
//        result.tail.setNext(a.head);
//        result.tail=a.tail;
//        a.head=null;
//    }
//
//
//
//
//    public void sort2(){
//        MyLinkedList result=fastSort(this);
//        this.head=result.head;
//        this.tail=result.tail;
//    }
//
//    public MyLinkedList fastSort(MyLinkedList param){
//        if(param.head==param.tail) return param;
//        MyLinkedList left=new MyLinkedList();
//        MyLinkedList right=new MyLinkedList();
//        MyLinkedList result=new MyLinkedList();
//
//        Node medium=param.head;
//        Node n=param.head;
//        do{
//            n=n.getNext();
//            if(n.getValue()<medium.getValue())
//                left.addNode(n);
//            else
//                right.addNode(n);
//        }while(n!=param.tail);
//
//        if(left.head != null){
//            left=fastSort(left);
//            left.tail.setNext(medium);
//            result.head = left.head;
//        }
//        else
//            result.head = medium;
//
//        if(right.head != null) {
//            right=fastSort(right);
//            medium.setNext(right.head);
//            result.tail = right.tail;
//        }
//        else
//            result.tail = medium;
//        return result;
//    }
//
//    public void addNode(Node n){
//        if(head==null){
//            head=n;
//            tail=n;
//        }
//        else {
//            tail.setNext(n);
//            tail=n;
//        }
//    }
//
//    @Override
//    public String toString(){
//        StringBuilder sb=new StringBuilder();
//        Node node=head;
//        while(node!=tail){
//            sb.append(node.getValue()+",");
//            node=node.getNext();
//        }
//        sb.append(tail.getValue());
//        return sb.toString();
//    }
//
//}