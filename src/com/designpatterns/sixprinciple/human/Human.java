package com.designpatterns.sixprinciple.human;

public abstract class Human {

    private String name;

    public Human(String _name){
        this.name=_name;
    }

    public String getName() {
        return name;
    }

}