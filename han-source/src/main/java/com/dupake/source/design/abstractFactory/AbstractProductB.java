package com.dupake.source.design.abstractFactory;

public abstract class AbstractProductB {

    //每个产品共有方法
    private void shareMethod(){
        System.out.println(getClass().getSimpleName() + ":AbstractProductB shareMethod-----------");
    };

    //每个产品相同方法不同实现
    public abstract void doStingthing();
}
