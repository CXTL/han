package com.dupake.source.design.proxy.dynamic2;

public class BeaforeAdvice implements IAdvice{
    @Override
    public void exec() {
        System.out.println("----------执行前置方法-----------");
    }
}
