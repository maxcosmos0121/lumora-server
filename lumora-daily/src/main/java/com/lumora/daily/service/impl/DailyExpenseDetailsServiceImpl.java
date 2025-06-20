package com.lumora.daily.service.impl;

import java.util.List;
import com.lumora.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lumora.daily.mapper.DailyExpenseDetailsMapper;
import com.lumora.daily.domain.DailyExpenseDetails;
import com.lumora.daily.service.IDailyExpenseDetailsService;

/**
 * 日常记录_每日支出明细Service业务层处理
 *
 * @author leo
 * @date 2025-06-21
 */
@Service
public class DailyExpenseDetailsServiceImpl implements IDailyExpenseDetailsService
{
    @Autowired
    private DailyExpenseDetailsMapper dailyExpenseDetailsMapper;

    /**
     * 查询日常记录_每日支出明细
     *
     * @param expenseDetailsId 日常记录_每日支出明细主键
     * @return 日常记录_每日支出明细
     */
    @Override
    public DailyExpenseDetails selectDailyExpenseDetailsByExpenseDetailsId(Long expenseDetailsId)
    {
        return dailyExpenseDetailsMapper.selectDailyExpenseDetailsByExpenseDetailsId(expenseDetailsId);
    }

    /**
     * 查询日常记录_每日支出明细列表
     *
     * @param dailyExpenseDetails 日常记录_每日支出明细
     * @return 日常记录_每日支出明细
     */
    @Override
    public List<DailyExpenseDetails> selectDailyExpenseDetailsList(DailyExpenseDetails dailyExpenseDetails)
    {
        return dailyExpenseDetailsMapper.selectDailyExpenseDetailsList(dailyExpenseDetails);
    }

    /**
     * 新增日常记录_每日支出明细
     *
     * @param dailyExpenseDetails 日常记录_每日支出明细
     * @return 结果
     */
    @Override
    public int insertDailyExpenseDetails(DailyExpenseDetails dailyExpenseDetails)
    {
        dailyExpenseDetails.setCreateTime(DateUtils.getNowDate());
        return dailyExpenseDetailsMapper.insertDailyExpenseDetails(dailyExpenseDetails);
    }

    /**
     * 修改日常记录_每日支出明细
     *
     * @param dailyExpenseDetails 日常记录_每日支出明细
     * @return 结果
     */
    @Override
    public int updateDailyExpenseDetails(DailyExpenseDetails dailyExpenseDetails)
    {
        dailyExpenseDetails.setUpdateTime(DateUtils.getNowDate());
        return dailyExpenseDetailsMapper.updateDailyExpenseDetails(dailyExpenseDetails);
    }

    /**
     * 批量删除日常记录_每日支出明细
     *
     * @param expenseDetailsIds 需要删除的日常记录_每日支出明细主键
     * @return 结果
     */
    @Override
    public int deleteDailyExpenseDetailsByExpenseDetailsIds(Long[] expenseDetailsIds)
    {
        return dailyExpenseDetailsMapper.deleteDailyExpenseDetailsByExpenseDetailsIds(expenseDetailsIds);
    }

    /**
     * 删除日常记录_每日支出明细信息
     *
     * @param expenseDetailsId 日常记录_每日支出明细主键
     * @return 结果
     */
    @Override
    public int deleteDailyExpenseDetailsByExpenseDetailsId(Long expenseDetailsId)
    {
        return dailyExpenseDetailsMapper.deleteDailyExpenseDetailsByExpenseDetailsId(expenseDetailsId);
    }
}
