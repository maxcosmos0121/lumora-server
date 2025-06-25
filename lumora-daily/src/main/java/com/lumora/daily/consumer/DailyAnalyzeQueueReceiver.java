package com.lumora.daily.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "dailyAnalyzeQueue")
public class DailyAnalyzeQueueReceiver {

    @RabbitHandler
    public void process(String mes) {
        System.out.println("消费者收到: " + mes);
    }

}
