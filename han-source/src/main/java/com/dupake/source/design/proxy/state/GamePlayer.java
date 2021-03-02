package com.dupake.source.design.proxy.state;

public class GamePlayer implements IGamePlayer{

    private String name = "";

    public GamePlayer(String name){
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println( "帐号："+username + "真是用户：" +name + "login.........");
    }

    @Override
    public void killBoss() {
        System.out.println( name + "killBoss.........");
    }

    @Override
    public void upgrade() {
        System.out.println( name + "upgrade.........");
    }
}
