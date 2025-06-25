package com.lumora.daily.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lumora.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lumora.common.annotation.Excel;

/**
 * 日常记录_每日支出对象 daily_expense
 *
 * @author leo
 * @date 2025-06-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DailyExpense extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 每日支出ID */
    private Long expenseId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDate day;

    /** 星期（1-7） */
    @Excel(name = "星期", readConverterExp = "1=-7")
    private String week;

    /** 支出总金额 */
    @Excel(name = "支出总金额")
    private BigDecimal totalAmount;

    /** 支出记录状态（Y提交 N未提交） */
    @Excel(name = "支出记录状态", readConverterExp = "Y=提交,N=未提交")
    private String expenseStatus;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
