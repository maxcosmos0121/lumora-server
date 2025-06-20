package com.lumora.daily.service;

import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.vo.DailyReportVo;
import com.lumora.daily.vo.DailyReportReqVo;
import com.lumora.daily.vo.DailyReportRespVo;

import java.util.List;

/**
 * 日常记录_每日日报Service接口
 *
 * @author Leo
 * @date 2025-06-11
 */
public interface IDailyReportService {
    /**
     * 查询日常记录_每日日报
     *
     * @param reportId 日常记录_每日日报主键
     * @return 日常记录_每日日报
     */
    public DailyReportRespVo selectDailyReportByReportId(Long reportId);

    /**
     * 查询日常记录_每日日报列表
     *
     * @param dailyReport 日常记录_每日日报
     * @return 日常记录_每日日报集合
     */
    public List<DailyReport> selectDailyReportList(DailyReportVo dailyReport);

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
     * 批量删除日常记录_每日日报
     *
     * @param reportIds 需要删除的日常记录_每日日报主键集合
     * @return 结果
     */
    public int deleteDailyReportByReportIds(Long[] reportIds);

    /**
     * 删除日常记录_每日日报信息
     *
     * @param reportId 日常记录_每日日报主键
     * @return 结果
     */
    public int deleteDailyReportByReportId(Long reportId);

    int submit(DailyReportReqVo dailyReport);

    int save(DailyReportReqVo dailyReport);

    /**
     * 批量新增日常记录_每日日报
     */
    void addDailyReportBatch();
}
