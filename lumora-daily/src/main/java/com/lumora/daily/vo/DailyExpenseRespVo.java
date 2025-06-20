package com.lumora.daily.vo;

import com.lumora.daily.domain.DailyExpense;
import com.lumora.daily.domain.DailyExpenseDetails;
import lombok.Data;

import java.util.List;

@Data
public class DailyExpenseRespVo {

    private DailyExpense dailyExpense;

    private List<DailyExpenseDetails> dailyExpenseDetails;


}
