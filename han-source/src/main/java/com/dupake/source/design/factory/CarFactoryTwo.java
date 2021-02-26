package com.dupake.source.design.factory;

public class CarFactoryTwo implements CarFatcory {

    @Override
    public IBaoma createBaoma() {
        return new BaomaTwo();
    }

    @Override
    public IAodi createAodi() {
        return new AodiTwo();
    }
}
