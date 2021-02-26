package com.dupake.source.design.factory;

public class Client {

    public static void main(String[] args) {
        CarFatcory carFatcory = new CarFactoryOne();
        carFatcory.createBaoma().doAnything();
        carFatcory.createAodi().doAnything();

        CarFatcory factoryTwo = new CarFactoryTwo();
        factoryTwo.createAodi().doAnything();
        factoryTwo.createBaoma().doAnything();

    }

}
