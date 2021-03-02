package com.dupake.source.design.proxy.dynamic;

import com.dupake.source.design.proxy.state.GamePlayer;
import com.dupake.source.design.proxy.state.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;

public class Client {

    public static void main(String[] args) {
        IGamePlayer iGamePlayer = new GamePlayer("张三");
        //定义一个handler
        InvocationHandler invocationHandler = new GamePlayIH(iGamePlayer);
        System.out.println("开始时间："+ LocalDateTime.now());
        //获取类 class loader
        ClassLoader classLoader = iGamePlayer.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, GamePlayer.class.getInterfaces(), invocationHandler);

        //登录
        proxy.login("zhangsan","123456");
        //杀怪
        proxy.killBoss();
        //升级
        proxy.upgrade();

        System.out.println("结束时间："+ LocalDateTime.now());
    }
}
