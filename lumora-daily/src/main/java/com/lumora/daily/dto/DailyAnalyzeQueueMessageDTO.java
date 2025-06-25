package com.lumora.daily.dto;

import com.lumora.daily.domain.DailyReport;
import lombok.Data;

import java.io.Serializable;

@Data
public class DailyAnalyzeQueueMessageDTO implements Serializable {
    private DailyReport dailyReport;

    private DailyReportContentDTO dailyReportContentDTO;
}
