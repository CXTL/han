package com.dupake.source.design.abstractFactory;

/**
 * 抽象产品类
 */
public abstract class AbstractProductA {

    //每个产品共有方法
    private void shareMethod(){
        System.out.println(getClass().getSimpleName() + ":AbstractProductA shareMethod-----------");
    };

    //每个产品相同方法不同实现
    public abstract void doStingthing();

}
