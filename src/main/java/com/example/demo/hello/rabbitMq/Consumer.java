package com.example.demo.hello.rabbitMq;

import org.springframework.stereotype.Component;

@Component
public class Consumer {


    public void workReceiver(){
        new Receiver();
    }
}
