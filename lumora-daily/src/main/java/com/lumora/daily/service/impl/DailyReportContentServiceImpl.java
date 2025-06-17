package com.lumora.daily.service.impl;

import java.util.List;
import com.lumora.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lumora.daily.mapper.DailyReportContentMapper;
import com.lumora.daily.domain.DailyReportContent;
import com.lumora.daily.service.IDailyReportContentService;

/**
 * 日常记录_每日日报内容Service业务层处理
 *
 * @author Leo
 * @date 2025-06-17
 */
@Service
public class DailyReportContentServiceImpl implements IDailyReportContentService
{
    @Autowired
    private DailyReportContentMapper dailyReportContentMapper;

    /**
     * 查询日常记录_每日日报内容
     *
     * @param reportContentId 日常记录_每日日报内容主键
     * @return 日常记录_每日日报内容
     */
    @Override
    public DailyReportContent selectDailyReportContentByReportContentId(Long reportContentId)
    {
        return dailyReportContentMapper.selectDailyReportContentByReportContentId(reportContentId);
    }

    /**
     * 查询日常记录_每日日报内容列表
     *
     * @param dailyReportContent 日常记录_每日日报内容
     * @return 日常记录_每日日报内容
     */
    @Override
    public List<DailyReportContent> selectDailyReportContentList(DailyReportContent dailyReportContent)
    {
        return dailyReportContentMapper.selectDailyReportContentList(dailyReportContent);
    }

    /**
     * 新增日常记录_每日日报内容
     *
     * @param dailyReportContent 日常记录_每日日报内容
     * @return 结果
     */
    @Override
    public int insertDailyReportContent(DailyReportContent dailyReportContent)
    {
        dailyReportContent.setCreateTime(DateUtils.getNowDate());
        return dailyReportContentMapper.insertDailyReportContent(dailyReportContent);
    }

    /**
     * 修改日常记录_每日日报内容
     *
     * @param dailyReportContent 日常记录_每日日报内容
     * @return 结果
     */
    @Override
    public int updateDailyReportContent(DailyReportContent dailyReportContent)
    {
        dailyReportContent.setUpdateTime(DateUtils.getNowDate());
        return dailyReportContentMapper.updateDailyReportContent(dailyReportContent);
    }

    /**
     * 批量删除日常记录_每日日报内容
     *
     * @param reportContentIds 需要删除的日常记录_每日日报内容主键
     * @return 结果
     */
    @Override
    public int deleteDailyReportContentByReportContentIds(Long[] reportContentIds)
    {
        return dailyReportContentMapper.deleteDailyReportContentByReportContentIds(reportContentIds);
    }

    /**
     * 删除日常记录_每日日报内容信息
     *
     * @param reportContentId 日常记录_每日日报内容主键
     * @return 结果
     */
    @Override
    public int deleteDailyReportContentByReportContentId(Long reportContentId)
    {
        return dailyReportContentMapper.deleteDailyReportContentByReportContentId(reportContentId);
    }
}
