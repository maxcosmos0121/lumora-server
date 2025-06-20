package com.lumora.daily.vo;

import com.lumora.daily.domain.DailyExpense;
import com.lumora.daily.dto.DailyExpenseDetailsDTO;
import lombok.Data;

import java.util.List;

@Data
public class DailyExpenseReqVo {

    private DailyExpense dailyExpense;

    private List<DailyExpenseDetailsDTO> dailyExpenseDetails;


}
