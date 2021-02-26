package com.dupake.source.design.factory;

import com.dupake.source.design.factory.IAodi;

public class AodiOne implements IAodi {

    @Override
    public void doSomething() {
        System.out.println("AodiOne doSomething----------------");
    }

    @Override
    public void doAnything() {
        System.out.println("AodiOne doAnything----------------");
    }
}
