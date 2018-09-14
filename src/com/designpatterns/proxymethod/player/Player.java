package com.designpatterns.proxymethod.player;

public abstract class Player {
    protected String name;

    public abstract void login(String userName,String password);

    public abstract void killBoss();

    public abstract void upgrad();
}