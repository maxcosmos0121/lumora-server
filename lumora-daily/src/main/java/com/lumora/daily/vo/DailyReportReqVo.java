package com.lumora.daily.vo;

import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.dto.DailyReportContentDTO;
import lombok.Data;

import java.util.List;

@Data
public class DailyReportReqVo {

    private DailyReport dailyReport;

    private List<DailyReportContentDTO> dailyReportContents;
}
