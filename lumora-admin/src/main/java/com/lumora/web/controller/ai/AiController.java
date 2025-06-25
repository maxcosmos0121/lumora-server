package com.lumora.web.controller.ai;

import com.lumora.common.core.domain.AjaxResult;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AI Controller
 *
 * @author leo
 * @date 2025-06-22
 */
@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/chat")
    public AjaxResult chat(String msg) {
        this.rabbitTemplate.convertAndSend("dailyAnalyzeQueue", msg);
        return AjaxResult.success();
    }

}
