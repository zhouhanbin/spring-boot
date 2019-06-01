package com.example.demo.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class test {

    public static void main(String[] args){
        Integer actionForce;
        Long rand = System.currentTimeMillis() % 10;
        actionForce = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(180),4,RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(1000)).setScale(1,RoundingMode.HALF_UP).intValue();
        // 余0上调、否则下降
        if (rand % 2 == 0) {
            actionForce += 100;
        } else {
            if (actionForce > 100) {
                actionForce -= 100;
            }
        }
        System.out.println(actionForce);
    }
}
