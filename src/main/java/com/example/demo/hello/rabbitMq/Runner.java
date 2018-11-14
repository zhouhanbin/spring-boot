package com.example.demo.hello.rabbitMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
//启动就加载 implements CommandLineRunner
public class Runner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

//    @Override
//    public void run(String... args) throws Exception{
//        System.out.println("Sending message...");
//        for (int i =0;i < 10; i++){
//            rabbitTemplate.convertAndSend("spring-boot-exchange","foo.bar.baz","Hello from RabbitMq");
//        }
//        receiver.getLatch().await(10000,TimeUnit.MILLISECONDS);
//    }
}
