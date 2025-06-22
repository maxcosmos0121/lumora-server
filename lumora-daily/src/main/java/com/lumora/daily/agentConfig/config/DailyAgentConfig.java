package com.lumora.daily.agentConfig.config;

import com.lumora.daily.agentConfig.agent.DailyAgent;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DailyAgentConfig {

    @Resource
    private ChatLanguageModel chatLanguageModel;

    @Bean
    public DailyAgent dailyAgent() {
        return AiServices.builder(DailyAgent.class)
                .chatLanguageModel(chatLanguageModel)
                .build();
    }

}
