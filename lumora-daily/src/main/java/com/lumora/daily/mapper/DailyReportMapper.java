package com.lumora.daily.mapper;

import com.lumora.daily.domain.DailyReport;

import java.util.List;

/**
 * 日常记录_每日日报Mapper接口
 *
 * @author Leo
 * @date 2025-06-11
 */
public interface DailyReportMapper {
    /**
     * 查询日常记录_每日日报
     *
     * @param reportId 日常记录_每日日报主键
     * @return 日常记录_每日日报
     */
    public DailyReport selectDailyReportByReportId(Long reportId);

    /**
     * 查询日常记录_每日日报列表
     *
     * @param dailyReport 日常记录_每日日报
     * @return 日常记录_每日日报集合
     */
    public List<DailyReport> selectDailyReportList(DailyReport dailyReport);

    /**
     * 新增日常记录_每日日报
     *
     * @param dailyReport 日常记录_每日日报
     * @return 结果
     */
    public int insertDailyReport(DailyReport dailyReport);

    /**
     * 修改日常记录_每日日报
     *
     * @param dailyReport 日常记录_每日日报
     * @return 结果
     */
    public int updateDailyReport(DailyReport dailyReport);

    /**
     * 删除日常记录_每日日报
     *
     * @param reportId 日常记录_每日日报主键
     * @return 结果
     */
    public int deleteDailyReportByReportId(Long reportId);

    /**
     * 批量删除日常记录_每日日报
     *
     * @param reportIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDailyReportByReportIds(Long[] reportIds);
}
