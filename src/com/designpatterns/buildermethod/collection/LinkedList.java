package com.designpatterns.buildermethod.collection;

public abstract class LinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public void addNode(int value){
        Node node =new Node();
        node.setValue(value);
        if(head==null) {
            head = node;
            tail=node;
        }
        else{
            tail.setNext(node);
            tail=node;
        }
    }

    public void addNode(Node n){
        if(head==null){
            head=n;
            tail=n;
        }
        else {
            tail.setNext(n);
            tail=n;
        }
    }

    public void deleteNode(T value){
        Node node=head;
        Node nullNode=new Node();
        Node pre=nullNode;
        while(head.getNext()!=null){
            node=head.getNext();
            if(value.equals(node.getValue())){
                if(pre!=nullNode)pre.setNext(node.getNext());

            }
            pre=node;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        Node node=head;
        while(node!=tail){
            sb.append(node.getValue()+",");
            node=node.getNext();
        }
        sb.append(tail.getValue());
        return sb.toString();
    }

    public abstract void sort();
}