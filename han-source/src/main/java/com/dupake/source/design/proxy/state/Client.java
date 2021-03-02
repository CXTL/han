package com.dupake.source.design.proxy.state;

public class Client {
    public static void main(String[] args) {
        IGamePlayer iGamePlayer = new GamePlayer("张三");
        IGamePlayer proxy = new GamePlayerProxy(iGamePlayer);
        proxy.login("zhangsan","123456");
        proxy.killBoss();
        proxy.upgrade();

    }
}
