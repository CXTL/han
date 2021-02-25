package com.dupake.source.design.singleton;

import java.util.Objects;

public class Singleton3 {

    private static Singleton3 singleton3 = null;

    private Singleton3(){

    }

    public synchronized Singleton3 getSingleton3() {
        if(Objects.isNull(singleton3)){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }


}
