package com.lumora.daily.consumer;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumora.daily.agentConfig.agent.DailyAgent;
import com.lumora.daily.domain.DailyExerciseRecord;
import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.dto.DailyAnalyzeQueueMessageDTO;
import com.lumora.daily.dto.DailyReportContentDTO;
import com.lumora.daily.service.IDailyExerciseRecordService;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
@RabbitListener(queues = "dailyAnalyzeQueue")
public class DailyAnalyzeQueueReceiver {

    @Data
    public class DailyAnalyzeQueueMessage{



    }

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private DailyAgent dailyAgent;

    @Resource
    private IDailyExerciseRecordService dailyExerciseRecordService;

    @RabbitHandler
    public void process(DailyAnalyzeQueueMessageDTO dto) {
        DailyReport report = dto.getDailyReport();
        DailyReportContentDTO contentDTO = dto.getDailyReportContentDTO();
        String contentType = contentDTO.getContentType();
        if (contentType.equals("6")) {
            DailyExerciseRecord dailyExerciseRecord = new DailyExerciseRecord();
            dailyExerciseRecord.setReportId(report.getReportId());
            dailyExerciseRecord.setReportContentId(contentDTO.getReportContentId());
            dailyExerciseRecord.setDay(report.getDay());
            dailyExerciseRecord.setWeek(report.getWeek());
            String result = dailyAgent.chat(contentDTO.getContent());
            String weight = ReUtil.get("<(.*?)>", result, 1);
            if (ObjectUtil.isEmpty(weight)) {
                return;
            }
            dailyExerciseRecord.setWeight(new BigDecimal(weight));
            dailyExerciseRecord.setCreateBy(report.getCreateBy());
            dailyExerciseRecordService.insertDailyExerciseRecord(dailyExerciseRecord);
        }
    }

}
