package com.dupake.source.design.proxy.dynamic3;

import com.dupake.source.design.proxy.dynamic2.BeaforeAdvice;
import com.dupake.source.design.proxy.dynamic2.DynamicProxy;
import com.dupake.source.design.proxy.dynamic2.MyInvocationHander;
import com.dupake.source.design.proxy.dynamic2.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 具体业务的动态代理
 */
public class SubjectDynamicProxy extends DynamicProxy {

    public static <T>T newProxyInstance(Subject subject){
        ClassLoader loader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler h = new MyInvocationHander(subject);
        //寻找JoinPoint连接点 aop框架使用元素数据定义
        if(true){
            (new BeaforeAdvice()).exec();
        }
        //执行代理目标返回结果
        return (T) Proxy.newProxyInstance(loader,interfaces,h);
    }

}
