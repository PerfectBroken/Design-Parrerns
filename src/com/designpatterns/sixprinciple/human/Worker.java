package com.designpatterns.sixprinciple.human;
import com.designpatterns.sixprinciple.work.Work;

public class Worker extends Human implements WorkDuty {

    public Worker(String name){
        super(name);
    }

    public void work(Work work){
        System.out.print(getName());
        work.working();
    }
}