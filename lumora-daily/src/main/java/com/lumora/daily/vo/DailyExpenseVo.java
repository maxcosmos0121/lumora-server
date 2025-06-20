package com.lumora.daily.vo;

import com.lumora.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DailyExpenseVo extends BaseEntity {

    /**
     * 日期
     */
    private String day;

    /**
     * 星期（1-7）
     */
    private String week;
}
