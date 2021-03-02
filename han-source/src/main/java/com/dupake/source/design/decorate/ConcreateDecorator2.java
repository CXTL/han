package com.dupake.source.design.decorate;

public class ConcreateDecorator2 extends Decorator{

    //定义被修饰者
    public ConcreateDecorator2(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void method2(){
        System.out.println("-----------exec method2----------");
    }

    //重写父类 operate 方法
    @Override
    public void operation() {
        this.method2();
        super.operation();
    }

}
