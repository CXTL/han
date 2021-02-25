package com.dupake.source.design.singleton;

public class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1(){

    }

    public Singleton1 getSingletonOne(){
        return singleton1;
    }


}
