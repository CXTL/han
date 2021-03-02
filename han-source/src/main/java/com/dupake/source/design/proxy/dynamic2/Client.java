package com.dupake.source.design.proxy.dynamic2;

import java.lang.reflect.InvocationHandler;

public class Client {

    public static void main(String[] args) {
        //定义主题
        Subject subject = new RealSubject();
        //定义handler
        InvocationHandler invocationHandler = new MyInvocationHander(subject);
        //定义主题的代理
        Subject proxyInstance = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), RealSubject.class.getInterfaces(), invocationHandler);
        //代理的行为
        proxyInstance.doSomething();

    }



}
