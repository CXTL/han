package com.dupake.source.design.singleton;

public class Singleton6 {


    private static  Singleton6 singleton6 = null;

    static {
        singleton6 = new Singleton6();
    }

    private Singleton6(){

    }

    public Singleton6 getSingleton4() {
        return singleton6;
    }


}
