package com.dupake.source.design.singleton;

import java.util.Objects;

/**
 * 初始化数据 jvm指令重排序
 */
public class Singleton4 {

    private static Singleton4 singleton4 = null;

    private Singleton4(){

    }

    public  Singleton4 getSingleton4() {
        if(Objects.isNull(singleton4)){
            synchronized(Singleton4.class){
                if(Objects.isNull(singleton4)){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }


}
