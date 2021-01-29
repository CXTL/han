package com.dupake.source.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private IndexService indexService;

    public UserService(){
        System.out.println("I am UserService");
    }

    public void getService(){
        System.out.println(indexService);
    }
}
