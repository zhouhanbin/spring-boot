package com.entity;
public final class Car {

    final String carBody;//车身
    final String tyre;//轮胎
    final String engine;//发动机 8    
    final String aimingCircle;//方向盘
    final String safetyBelt;//安全带
    /**
     * 可选属性
     */
    final String decoration;//车内装饰品

    public Car(Builder builder) {
        this.carBody = builder.carBody;
        this.tyre = builder.tyre;
        this.engine = builder.engine;
        this.aimingCircle = builder.aimingCircle;
        this.decoration = builder.decoration;
        this.safetyBelt = builder.safetyBelt;
    }

    public static final class Builder {
        String carBody;
        String tyre;
        String engine;
        String aimingCircle;
        String decoration;
        String safetyBelt;

    }
}
