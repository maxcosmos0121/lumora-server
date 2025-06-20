package com.lumora.daily.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lumora.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lumora.common.annotation.Excel;

/**
 * 日常记录_每日支出对象 daily_expense
 *
 * @author leo
 * @date 2025-06-20
 */
public class DailyExpense extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 每日支出ID */
    private Long expenseId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date day;

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

    public void setExpenseId(Long expenseId)
    {
        this.expenseId = expenseId;
    }

    public Long getExpenseId()
    {
        return expenseId;
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

    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }

    public void setExpenseStatus(String expenseStatus)
    {
        this.expenseStatus = expenseStatus;
    }

    public String getExpenseStatus()
    {
        return expenseStatus;
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
            .append("expenseId", getExpenseId())
            .append("day", getDay())
            .append("week", getWeek())
            .append("totalAmount", getTotalAmount())
            .append("expenseStatus", getExpenseStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
