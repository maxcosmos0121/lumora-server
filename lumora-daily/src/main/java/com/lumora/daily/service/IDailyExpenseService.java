package com.lumora.daily.service;

import java.util.List;
import com.lumora.daily.domain.DailyExpense;
import com.lumora.daily.vo.DailyExpenseReqVo;
import com.lumora.daily.vo.DailyExpenseRespVo;
import com.lumora.daily.vo.DailyExpenseVo;

/**
 * 日常记录_每日支出Service接口
 *
 * @author leo
 * @date 2025-06-20
 */
public interface IDailyExpenseService
{
    /**
     * 查询日常记录_每日支出
     *
     * @param expenseId 日常记录_每日支出主键
     * @return 日常记录_每日支出
     */
    public DailyExpenseRespVo selectDailyExpenseByExpenseId(Long expenseId);

    /**
     * 查询日常记录_每日支出列表
     *
     * @param dailyExpense 日常记录_每日支出
     * @return 日常记录_每日支出集合
     */
    public List<DailyExpense> selectDailyExpenseList(DailyExpenseVo dailyExpense);

    /**
     * 新增日常记录_每日支出
     *
     * @param dailyExpense 日常记录_每日支出
     * @return 结果
     */
    public int insertDailyExpense(DailyExpense dailyExpense);

    /**
     * 修改日常记录_每日支出
     *
     * @param dailyExpense 日常记录_每日支出
     * @return 结果
     */
    public int updateDailyExpense(DailyExpense dailyExpense);

    /**
     * 批量删除日常记录_每日支出
     *
     * @param expenseIds 需要删除的日常记录_每日支出主键集合
     * @return 结果
     */
    public int deleteDailyExpenseByExpenseIds(Long[] expenseIds);

    /**
     * 删除日常记录_每日支出信息
     *
     * @param expenseId 日常记录_每日支出主键
     * @return 结果
     */
    public int deleteDailyExpenseByExpenseId(Long expenseId);

    int save(DailyExpenseReqVo dailyExpense);

    int submit(DailyExpenseReqVo dailyExpense);

}
