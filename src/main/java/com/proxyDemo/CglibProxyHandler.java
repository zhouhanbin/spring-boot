package com.proxyDemo;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyHandler implements MethodInterceptor {

    private Object target;

    public Object getProxyInstance(final Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理先进行谈判……");
        // 唱歌需要明星自己来唱
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("演出完代理去收钱……");
        return result;
    }
}
