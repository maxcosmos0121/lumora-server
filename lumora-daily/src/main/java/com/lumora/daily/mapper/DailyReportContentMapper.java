package com.lumora.daily.mapper;

import java.util.List;
import com.lumora.daily.domain.DailyReportContent;

/**
 * 日常记录_每日日报内容Mapper接口
 * 
 * @author Leo
 * @date 2025-06-17
 */
public interface DailyReportContentMapper 
{
    /**
     * 查询日常记录_每日日报内容
     * 
     * @param reportContentId 日常记录_每日日报内容主键
     * @return 日常记录_每日日报内容
     */
    public DailyReportContent selectDailyReportContentByReportContentId(Long reportContentId);

    /**
     * 查询日常记录_每日日报内容列表
     * 
     * @param dailyReportContent 日常记录_每日日报内容
     * @return 日常记录_每日日报内容集合
     */
    public List<DailyReportContent> selectDailyReportContentList(DailyReportContent dailyReportContent);

    /**
     * 新增日常记录_每日日报内容
     * 
     * @param dailyReportContent 日常记录_每日日报内容
     * @return 结果
     */
    public int insertDailyReportContent(DailyReportContent dailyReportContent);

    /**
     * 修改日常记录_每日日报内容
     * 
     * @param dailyReportContent 日常记录_每日日报内容
     * @return 结果
     */
    public int updateDailyReportContent(DailyReportContent dailyReportContent);

    /**
     * 删除日常记录_每日日报内容
     * 
     * @param reportContentId 日常记录_每日日报内容主键
     * @return 结果
     */
    public int deleteDailyReportContentByReportContentId(Long reportContentId);

    /**
     * 批量删除日常记录_每日日报内容
     * 
     * @param reportContentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDailyReportContentByReportContentIds(Long[] reportContentIds);
}
