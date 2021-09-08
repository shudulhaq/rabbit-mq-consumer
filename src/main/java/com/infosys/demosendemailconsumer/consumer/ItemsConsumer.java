package com.infosys.demosendemailconsumer.consumer;

import com.infosys.demosendemailconsumer.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "items-queue")
    public void menerima(){
        System.out.println("menerima kiriman dari");

        emailService.send();
    }
}
