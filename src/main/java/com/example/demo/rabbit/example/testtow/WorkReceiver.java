package com.example.demo.rabbit.example.testtow;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkReceiver {


    private String receiverInstance;

    public WorkReceiver(String receiverInstance) {
        this.receiverInstance = receiverInstance;
    }

    @RabbitListener(queues = "work-queue")
    public void receive(String str) {
        System.out.println(receiverInstance.concat(" =====: ").concat(str));
    }

}
