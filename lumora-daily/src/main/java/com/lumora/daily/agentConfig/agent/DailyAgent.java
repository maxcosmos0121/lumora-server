package com.lumora.daily.agentConfig.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface DailyAgent {


    @SystemMessage("你需要将运动日报内容中的体重解析出来，然后返回体重的值，单位是KG，返回的模板是<体重的值>，例如：<70>")
    String chat(@UserMessage String message);

}
