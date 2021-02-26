package com.dupake.source.design.factory;

import com.dupake.source.design.factory.IAodi;

public class AodiTwo implements IAodi {

    @Override
    public void doSomething() {
        System.out.println("AodiTwo doSomething----------------");
    }

    @Override
    public void doAnything() {
        System.out.println("AodiTwo doAnything----------------");
    }
}
