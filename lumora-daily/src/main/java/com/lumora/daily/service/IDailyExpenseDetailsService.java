package com.lumora.daily.service;

import java.util.List;
import com.lumora.daily.domain.DailyExpenseDetails;

/**
 * 日常记录_每日支出明细Service接口
 * 
 * @author leo
 * @date 2025-06-21
 */
public interface IDailyExpenseDetailsService 
{
    /**
     * 查询日常记录_每日支出明细
     * 
     * @param expenseDetailsId 日常记录_每日支出明细主键
     * @return 日常记录_每日支出明细
     */
    public DailyExpenseDetails selectDailyExpenseDetailsByExpenseDetailsId(Long expenseDetailsId);

    /**
     * 查询日常记录_每日支出明细列表
     * 
     * @param dailyExpenseDetails 日常记录_每日支出明细
     * @return 日常记录_每日支出明细集合
     */
    public List<DailyExpenseDetails> selectDailyExpenseDetailsList(DailyExpenseDetails dailyExpenseDetails);

    /**
     * 新增日常记录_每日支出明细
     * 
     * @param dailyExpenseDetails 日常记录_每日支出明细
     * @return 结果
     */
    public int insertDailyExpenseDetails(DailyExpenseDetails dailyExpenseDetails);

    /**
     * 修改日常记录_每日支出明细
     * 
     * @param dailyExpenseDetails 日常记录_每日支出明细
     * @return 结果
     */
    public int updateDailyExpenseDetails(DailyExpenseDetails dailyExpenseDetails);

    /**
     * 批量删除日常记录_每日支出明细
     * 
     * @param expenseDetailsIds 需要删除的日常记录_每日支出明细主键集合
     * @return 结果
     */
    public int deleteDailyExpenseDetailsByExpenseDetailsIds(Long[] expenseDetailsIds);

    /**
     * 删除日常记录_每日支出明细信息
     * 
     * @param expenseDetailsId 日常记录_每日支出明细主键
     * @return 结果
     */
    public int deleteDailyExpenseDetailsByExpenseDetailsId(Long expenseDetailsId);
}
