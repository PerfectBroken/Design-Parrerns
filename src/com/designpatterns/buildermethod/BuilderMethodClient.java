package com.designpatterns.buildermethod;

import com.designpatterns.buildermethod.builder.AbstrackBuilder;
import com.designpatterns.buildermethod.builder.LinkedListBuilder;
import com.designpatterns.buildermethod.collection.LinkedList;
import com.designpatterns.buildermethod.comparetor.IntegerASCComparetor;
import com.designpatterns.buildermethod.comparetor.IntegerDECComparetor;
import com.designpatterns.buildermethod.sorter.FastSorter;
import com.designpatterns.buildermethod.sorter.MergeSorter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class BuilderMethodClient {
    public static void main(String[] args) {
        /*
         *本测试使用装配者模式（模板模式）为链表准备排序器、比较器
         * 实现链表的可配置排序
         */
        FastSorter<Integer> fastSorter = new FastSorter<>();
        MergeSorter<Integer> mergeSorter = new MergeSorter<>();

        IntegerASCComparetor ascComparetor = new IntegerASCComparetor();
        IntegerDECComparetor decComparetor = new IntegerDECComparetor();

        ArrayList<Object> sequenceListF = new ArrayList<>();
        sequenceListF.add(fastSorter);
        sequenceListF.add(ascComparetor);

        ArrayList<Object> sequenceListM = new ArrayList<>();
        sequenceListM.add(mergeSorter);
        sequenceListM.add(ascComparetor);
        AbstrackBuilder<Integer> builder = new LinkedListBuilder<>();




        int j=30;
        boolean whichSort=false;
        while (j-- >= 0) {
            if(whichSort=!whichSort){
                builder.setSequence(sequenceListF.toArray());
            }
            else{
                builder.setSequence(sequenceListM.toArray());
            }

            LinkedList<Integer> mylist = builder.getLinkedList();

            Random random = new Random();
            for (int i = 0; i < 2000000; i++) {
                int value = random.nextInt() % 10000000;
                mylist.addNode(value);
            }
//            System.out.println(mylist.toString());
            long t = new Date().getTime();
            mylist.sort();
            System.out.println(new Date().getTime() - t);
//            System.out.println(mylist.toString());
            System.out.println("*****************************");
            mylist=null;
        }
    }
}