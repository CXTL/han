package com.dupake.source.design.proxy.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {

    public static <T>T newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h){
        //寻找JoinPoint连接点 aop框架使用元素数据定义
        if(true){
            (new BeaforeAdvice()).exec();
        }
        //执行代理目标返回结果
        return (T) Proxy.newProxyInstance(loader,interfaces,h);
    }

}
