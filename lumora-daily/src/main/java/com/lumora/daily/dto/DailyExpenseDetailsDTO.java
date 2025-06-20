package com.lumora.daily.dto;

import com.lumora.daily.domain.DailyExpenseDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DailyExpenseDetailsDTO extends DailyExpenseDetails {

    private String status;

}
