package com.example.demo.rabbit.example.controller;

import com.example.demo.rabbit.example.rabbitthree.FanoutSender;
import com.example.demo.rabbit.example.testfive.Producer;
import com.example.demo.rabbit.example.testone.HelloSender;
import com.example.demo.rabbit.example.entity.ObjectData;
import com.example.demo.rabbit.example.testtow.WorkSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitHelloController {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private WorkSend workSend;

    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping("testObject")
    public void testObject(){
        ObjectData user = new ObjectData();
        user.setName("张博");
        user.setSex("男");
        helloSender.sendObj(user);
    }


    @RequestMapping("testString")
    public String  testString(String massage){
        helloSender.send(massage);
        return massage;
    }

    @RequestMapping("testMany")
    public String  testMany(String massage){
        workSend.send();
        return massage;
    }


    @RequestMapping("/send")
    public String send() {
        fanoutSender.send();
        return "send ok";
    }


    @Autowired
    private Producer producer;

    @RequestMapping("/fiveSend")
    public String fiveSend() {
        producer.send();
        return "send ok";
    }

}
