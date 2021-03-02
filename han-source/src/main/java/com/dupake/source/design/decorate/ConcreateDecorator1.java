package com.dupake.source.design.decorate;

public class ConcreateDecorator1 extends Decorator{

    //定义被修饰者
    public ConcreateDecorator1(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void method1(){
        System.out.println("-----------exec method1----------");
    }

    //重写父类 operate 方法
    @Override
    public void operation() {
        this.method1();
        super.operation();
    }

}
