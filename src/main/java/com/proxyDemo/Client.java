package com.proxyDemo;

public class Client {


    public static void main(String[] args){
        Star realStar = new StarImpl();
        // 静态代理方法
//        Star proxy = new ProxyStar(star);
        // jdk动态代理
//        Star proxy = (Star) new JdkProxyHandler(star).getProxyHandler();
        // cglib 动态代理
        Star proxy = (Star) new CglibProxyHandler().getProxyInstance(realStar);
        proxy.sing();
    }
}
