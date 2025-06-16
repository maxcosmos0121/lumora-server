package com.lumora.daily.dto;

import com.lumora.common.annotation.Excel;
import com.lumora.common.core.domain.BaseEntity;


public class DailyReportDTO  extends BaseEntity {

    /**
     * 日期
     */
    private String day;

    /**
     * 星期（1-7）
     */
    @Excel(name = "星期", readConverterExp = "1=-7")
    private String week;


    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
