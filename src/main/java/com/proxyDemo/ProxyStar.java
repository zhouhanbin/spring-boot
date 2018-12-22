package com.proxyDemo;

public class ProxyStar implements Star{

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("在你唱歌之前。我要做点什么");
        this.star.sing();
        System.out.println("在你唱歌之后。开始收钱了");
    }
}
