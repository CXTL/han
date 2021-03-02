package com.dupake.source.design.proxy.dynamic2;

public class RealSubject  implements Subject{
    @Override
    public void doSomething() {
        System.out.println("-------do some thing------");
    }
}
