package com.dupake.source.design.proxy.dynamic3;

import com.dupake.source.design.proxy.dynamic2.RealSubject;
import com.dupake.source.design.proxy.dynamic2.Subject;

/**
 * 生成的类是继承 Proxy的,所以为什么JDK动态代理不能代理类了，只能代理接口，不能多继承
 *
 * 代理伪代码
 * public final class $Proxy0 extends Proxy implements Subject{};
 */
public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = new RealSubject();
        Subject o = SubjectDynamicProxy.newProxyInstance(subject);
        o.doSomething();

    }
}
