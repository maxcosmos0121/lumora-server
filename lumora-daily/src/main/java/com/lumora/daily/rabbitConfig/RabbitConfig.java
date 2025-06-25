package com.lumora.daily.rabbitConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 处理 日报解析的消息队列
     *
     * @return
     */
    @Bean
    public Queue dailyAnalyzeQueue() {
        return new Queue("dailyAnalyzeQueue", false);
    }

}
