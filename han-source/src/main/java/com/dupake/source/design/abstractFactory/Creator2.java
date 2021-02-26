package com.dupake.source.design.abstractFactory;

/**
 * 产品等级2的实现类
 */
public class Creator2 extends AbstractCreator{
    @Override
    public AbstractProductA createAbstractProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createAbstractProductB() {
        return new ProductB2();
    }
}
