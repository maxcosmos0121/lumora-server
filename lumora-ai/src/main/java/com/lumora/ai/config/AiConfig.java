package com.lumora.ai.config;


import dev.langchain4j.community.model.zhipu.ZhipuAiChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


/**
 * AI配置
 */
@Configuration
public class AiConfig {

    @Bean
    public ChatLanguageModel aiAssistant() {
        return ZhipuAiChatModel.builder()
                .apiKey("49360798ae6b40d08cb4b9c4ad7569aa.LQZKL5WvLpZV21y6")
                .model("GLM-4-Flash-250414")
                .temperature(0.6)
                .maxToken(1024)
                .maxRetries(1)
                .callTimeout(Duration.ofSeconds(60))
                .connectTimeout(Duration.ofSeconds(60))
                .writeTimeout(Duration.ofSeconds(60))
                .readTimeout(Duration.ofSeconds(60))
                .build();
    }
}
