package com.designpatterns.proxymethod.hanlder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.designpatterns.proxymethod.player.Player;
public class GamePlayerHandler implements InvocationHandler {
    Class cls=null;

    Player player=null;

    public GamePlayerHandler(Player player){
        cls=player.getClass();
        this.player=player;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable{
        Object object=method.invoke(player,args);
        return object;
    }
}