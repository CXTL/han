package com.dupake.source.design.abstractFactory;

/**
 * 产品等级1的实现类
 */
public class Creator1 extends AbstractCreator{
    @Override
    public AbstractProductA createAbstractProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createAbstractProductB() {
        return new ProductB1();
    }
}
