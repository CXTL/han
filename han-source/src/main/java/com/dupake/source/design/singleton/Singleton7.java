package com.dupake.source.design.singleton;

/**
 * 静态内部类
 */
public class Singleton7 {

    private Singleton7(){

    }
    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public Singleton7 getSingleton4() {
        return SingletonInstance.INSTANCE;
    }


}
