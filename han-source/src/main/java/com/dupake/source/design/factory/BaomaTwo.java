package com.dupake.source.design.factory;

import com.dupake.source.design.factory.IBaoma;

public class BaomaTwo implements IBaoma {

    @Override
    public void doSomething() {
        System.out.println("BaomaTwo doSomething----------------");
    }

    @Override
    public void doAnything() {
        System.out.println("BaomaTwo doAnything----------------");
    }
}
