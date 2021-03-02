package com.dupake.source.design.decorate;

public class Decorator extends Component{

    private Component component = null;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        this.component.operation();
    }
}
