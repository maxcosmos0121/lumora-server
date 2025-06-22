package com.lumora.daily.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lumora.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lumora.common.annotation.Excel;

/**
 * 日常记录_运动记录对象 daily_exercise_record
 *
 * @author leo
 * @date 2025-06-22
 */
public class DailyExerciseRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运动记录ID */
    private Long exerciseRecordId;

    /** 每日日报ID */
    @Excel(name = "每日日报ID")
    private Long reportId;

    /** 每日日报内容ID */
    @Excel(name = "每日日报内容ID")
    private Long reportContentId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date day;

    /** 星期（1-7） */
    @Excel(name = "星期", readConverterExp = "1=-7")
    private String week;

    /** 体重【单位kg】 */
    @Excel(name = "体重【单位kg】")
    private BigDecimal weight;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setExerciseRecordId(Long exerciseRecordId)
    {
        this.exerciseRecordId = exerciseRecordId;
    }

    public Long getExerciseRecordId()
    {
        return exerciseRecordId;
    }

    public void setReportId(Long reportId)
    {
        this.reportId = reportId;
    }

    public Long getReportId()
    {
        return reportId;
    }

    public void setReportContentId(Long reportContentId)
    {
        this.reportContentId = reportContentId;
    }

    public Long getReportContentId()
    {
        return reportContentId;
    }

    public void setDay(Date day)
    {
        this.day = day;
    }

    public Date getDay()
    {
        return day;
    }

    public void setWeek(String week)
    {
        this.week = week;
    }

    public String getWeek()
    {
        return week;
    }

    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    public BigDecimal getWeight()
    {
        return weight;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("exerciseRecordId", getExerciseRecordId())
            .append("reportId", getReportId())
            .append("reportContentId", getReportContentId())
            .append("day", getDay())
            .append("week", getWeek())
            .append("weight", getWeight())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
