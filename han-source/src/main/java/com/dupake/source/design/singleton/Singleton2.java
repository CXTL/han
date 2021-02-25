package com.dupake.source.design.singleton;

import java.util.Objects;

public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2(){

    }

    public Singleton2 getSingletonTwo() {
        if(Objects.isNull(singleton2)){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }


}
