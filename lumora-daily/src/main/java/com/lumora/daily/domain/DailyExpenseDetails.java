package com.lumora.daily.domain;

import java.math.BigDecimal;

import com.lumora.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lumora.common.annotation.Excel;

/**
 * 日常记录_每日支出明细对象 daily_expense_details
 *
 * @author leo
 * @date 2025-06-21
 */
public class DailyExpenseDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 每日支出明细ID */
    private Long expenseDetailsId;

    /** 每日支出ID */
    @Excel(name = "每日支出ID")
    private Long expenseId;

    /** 支出类型 */
    @Excel(name = "支出类型")
    private String expenseType;

    /** 支出金额 */
    @Excel(name = "支出金额")
    private BigDecimal expenseAmount;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setExpenseDetailsId(Long expenseDetailsId)
    {
        this.expenseDetailsId = expenseDetailsId;
    }

    public Long getExpenseDetailsId()
    {
        return expenseDetailsId;
    }

    public void setExpenseId(Long expenseId)
    {
        this.expenseId = expenseId;
    }

    public Long getExpenseId()
    {
        return expenseId;
    }

    public void setExpenseType(String expenseType)
    {
        this.expenseType = expenseType;
    }

    public String getExpenseType()
    {
        return expenseType;
    }

    public void setExpenseAmount(BigDecimal expenseAmount)
    {
        this.expenseAmount = expenseAmount;
    }

    public BigDecimal getExpenseAmount()
    {
        return expenseAmount;
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
            .append("expenseDetailsId", getExpenseDetailsId())
            .append("expenseId", getExpenseId())
            .append("expenseType", getExpenseType())
            .append("expenseAmount", getExpenseAmount())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
