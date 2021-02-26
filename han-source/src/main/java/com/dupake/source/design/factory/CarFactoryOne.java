package com.dupake.source.design.factory;

public class CarFactoryOne implements CarFatcory {

    @Override
    public IBaoma createBaoma() {
        return new BaomaOne();
    }

    @Override
    public IAodi createAodi() {
        return new AodiOne();
    }
}
