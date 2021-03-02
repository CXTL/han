package com.dupake.source.design.decorate;

public class Client {

    public static void main(String[] args) {
        Component component = new ConcreateComponent();
        Decorator decorator1 = new ConcreateDecorator1(component);
        Decorator decorator2 = new ConcreateDecorator2(component);
        decorator1.operation();
        decorator2.operation();


    }

}
