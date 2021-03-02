package com.dupake.source.design.proxy.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHander implements InvocationHandler {

    //被代理的对象
    private Object target;

    public MyInvocationHander(Object obj){
        this.target = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target,args);
    }
}
