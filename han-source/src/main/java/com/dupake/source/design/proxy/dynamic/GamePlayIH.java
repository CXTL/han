package com.dupake.source.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {

    //被代理者
    Class cls = null;

    //被代理的实例
    Object obj = null;

    //我要代理谁
    public GamePlayIH(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("login")){
            System.out.println("-----------before--------");
            System.out.println("-----------有人登录了我的帐号--------");
        }
        Object result = method.invoke(this.obj, args);
        return result;
    }
}
