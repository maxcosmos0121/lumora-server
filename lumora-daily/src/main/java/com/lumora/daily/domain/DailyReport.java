package com.lumora.daily.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lumora.common.annotation.Excel;
import com.lumora.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.util.Date;

/**
 * 日常记录_每日日报对象 daily_report
 *
 * @author Leo
 * @date 2025-06-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
    private LocalDate day;

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
     * 日报状态（Y提交 N未提交）
     */
    @Excel(name = "日报状态")
    private String reportStatus;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

}
