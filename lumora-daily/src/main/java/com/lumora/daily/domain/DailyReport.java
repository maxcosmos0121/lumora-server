package com.lumora.daily.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lumora.common.annotation.Excel;
import com.lumora.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 日常记录_每日日报对象 daily_report
 *
 * @author Leo
 * @date 2025-06-11
 */
public class DailyReport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 每日日报ID
     */
    private Long reportId;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date day;

    /**
     * 星期（1-7）
     */
    @Excel(name = "星期", readConverterExp = "1=-7")
    private String week;

    /**
     * 城市
     */
    @Excel(name = "城市")
    private String city;

    /**
     * 天气
     */
    @Excel(name = "天气")
    private String weather;

    /**
     * 心情
     */
    @Excel(name = "心情")
    private String mood;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("reportId", getReportId())
                .append("day", getDay())
                .append("week", getWeek())
                .append("city", getCity())
                .append("weather", getWeather())
                .append("mood", getMood())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
