package com.lumora.daily.vo;

import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.domain.DailyReportContent;
import lombok.Data;

import java.util.List;

@Data
public class DailyReportRespVo {

    private DailyReport dailyReport;

    private List<DailyReportContent> dailyReportContents;

}
