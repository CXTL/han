package com.dupake.source.design.singleton;

import java.util.Objects;

public class Singleton5 {

    //解决指令重排序
    private static volatile Singleton5 singleton5 = null;

    private Singleton5(){

    }

    public  Singleton5 getSingleton4() {
        if(Objects.isNull(singleton5)){
            synchronized(Singleton5.class){
                if(Objects.isNull(singleton5)){
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }


}
