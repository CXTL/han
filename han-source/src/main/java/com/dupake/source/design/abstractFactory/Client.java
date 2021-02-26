package com.dupake.source.design.abstractFactory;

public class Client {
    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        creator1.createAbstractProductA().doStingthing();
        creator1.createAbstractProductB().doStingthing();


        AbstractCreator creator2 = new Creator2();
        creator2.createAbstractProductA().doStingthing();
        creator2.createAbstractProductB().doStingthing();
    }
}
