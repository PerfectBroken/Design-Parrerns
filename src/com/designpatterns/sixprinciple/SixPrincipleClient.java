package com.designpatterns.sixprinciple;

import com.designpatterns.sixprinciple.tool.*;
import com.designpatterns.sixprinciple.work.*;
import com.designpatterns.sixprinciple.human.*;
import com.designpatterns.sixprinciple.human.Worker;

public class SixPrincipleClient {

    public static void main(String[] args){
        //单一原则，依赖倒置原则
        WorkDuty worker=new Worker("geralt.guo");
        Tool software=new Software();
        Work program=new Program();

        program.setTool(software);
        worker.work(program);

        System.out.print("\n");
        //李氏替换规则
        Tool IDEA=new IDEA();
        program.setTool(IDEA);
        worker.work(program);

        //迪米特法则(worker不依赖tool)
        //接口隔离原则
        //开闭原则？

    }
}