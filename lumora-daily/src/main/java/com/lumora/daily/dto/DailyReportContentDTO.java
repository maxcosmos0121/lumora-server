package com.lumora.daily.dto;

import com.lumora.daily.domain.DailyReportContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DailyReportContentDTO extends DailyReportContent {

    private String status;

}
