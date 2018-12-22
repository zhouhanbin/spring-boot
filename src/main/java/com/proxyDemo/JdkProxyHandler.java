package com.proxyDemo;

import java.lang.reflect.Proxy;

public class JdkProxyHandler {

    private Object star;

    public JdkProxyHandler(Object star) {
        super();
        this.star = star;
    }

    public Object getProxyHandler() {
        return Proxy.newProxyInstance(star.getClass().getClassLoader(),star.getClass().getInterfaces(),
                (proxy,method,args) -> {
                    System.out.println("代理先进行谈判……");
                    // 唱歌需要明星自己来唱
                    Object object = method.invoke(star, args);
                    System.out.println("演出完代理去收钱……");
                    return object;
                });
    }
}
