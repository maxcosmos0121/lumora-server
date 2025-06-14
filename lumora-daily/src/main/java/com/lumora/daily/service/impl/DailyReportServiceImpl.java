package com.lumora.daily.service.impl;

import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.mapper.DailyReportMapper;
import com.lumora.daily.service.IDailyReportService;
import com.lumora.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日常记录_每日日报Service业务层处理
 *
 * @author Leo
 * @date 2025-06-11
 */
@Service
public class DailyReportServiceImpl implements IDailyReportService {
    @Autowired
    private DailyReportMapper dailyReportMapper;

    /**
     * 查询日常记录_每日日报
     *
     * @param reportId 日常记录_每日日报主键
     * @return 日常记录_每日日报
     */
    @Override
    public DailyReport selectDailyReportByReportId(Long reportId) {
        return dailyReportMapper.selectDailyReportByReportId(reportId);
    }

    /**
     * 查询日常记录_每日日报列表
     *
     * @param dailyReport 日常记录_每日日报
     * @return 日常记录_每日日报
     */
    @Override
    public List<DailyReport> selectDailyReportList(DailyReport dailyReport) {
        return dailyReportMapper.selectDailyReportList(dailyReport);
    }

    /**
     * 新增日常记录_每日日报
     *
     * @param dailyReport 日常记录_每日日报
     * @return 结果
     */
    @Override
    public int insertDailyReport(DailyReport dailyReport) {
        dailyReport.setCreateTime(DateUtils.getNowDate());
        return dailyReportMapper.insertDailyReport(dailyReport);
    }

    /**
     * 修改日常记录_每日日报
     *
     * @param dailyReport 日常记录_每日日报
     * @return 结果
     */
    @Override
    public int updateDailyReport(DailyReport dailyReport) {
        dailyReport.setUpdateTime(DateUtils.getNowDate());
        return dailyReportMapper.updateDailyReport(dailyReport);
    }

    /**
     * 批量删除日常记录_每日日报
     *
     * @param reportIds 需要删除的日常记录_每日日报主键
     * @return 结果
     */
    @Override
    public int deleteDailyReportByReportIds(Long[] reportIds) {
        return dailyReportMapper.deleteDailyReportByReportIds(reportIds);
    }

    /**
     * 删除日常记录_每日日报信息
     *
     * @param reportId 日常记录_每日日报主键
     * @return 结果
     */
    @Override
    public int deleteDailyReportByReportId(Long reportId) {
        return dailyReportMapper.deleteDailyReportByReportId(reportId);
    }
}
