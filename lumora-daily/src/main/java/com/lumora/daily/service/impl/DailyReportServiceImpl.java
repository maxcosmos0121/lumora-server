package com.lumora.daily.service.impl;

import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.domain.DailyReportContent;
import com.lumora.daily.dto.DailyReportContentDTO;
import com.lumora.daily.dto.DailyReportDTO;
import com.lumora.daily.mapper.DailyReportMapper;
import com.lumora.daily.service.IDailyReportContentService;
import com.lumora.daily.service.IDailyReportService;
import com.lumora.common.utils.DateUtils;
import com.lumora.daily.vo.DailyReportReqVo;
import com.lumora.daily.vo.DailyReportRespVo;
import jakarta.annotation.Resource;
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

    @Autowired
    private IDailyReportContentService dailyReportContentService;

    /**
     * 查询日常记录_每日日报
     *
     * @param reportId 日常记录_每日日报主键
     * @return 日常记录_每日日报
     */
    @Override
    public DailyReportRespVo selectDailyReportByReportId(Long reportId) {
        DailyReportRespVo dailyReportRespVo = new DailyReportRespVo();
        DailyReport dailyReport = dailyReportMapper.selectDailyReportByReportId(reportId);
        DailyReportContent dailyReportContent = new DailyReportContent();
        dailyReportContent.setReportId(reportId);
        List<DailyReportContent> dailyReportContents = dailyReportContentService.selectDailyReportContentList(dailyReportContent);
        dailyReportRespVo.setDailyReport(dailyReport);
        dailyReportRespVo.setDailyReportContents(dailyReportContents);
        return dailyReportRespVo;
    }

    /**
     * 查询日常记录_每日日报列表
     *
     * @param dailyReport 日常记录_每日日报
     * @return 日常记录_每日日报
     */
    @Override
    public List<DailyReport> selectDailyReportList(DailyReportDTO dailyReport) {
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

    @Override
    public int submit(DailyReportReqVo dailyReport) {
        DailyReport report = dailyReport.getDailyReport();
        int i = this.updateDailyReport(report);
        List<DailyReportContentDTO> dailyReportContents = dailyReport.getDailyReportContents();
        dailyReportContents.forEach(contentDTO -> {
            switch (contentDTO.getStatus()) {
                case "add": {
                    contentDTO.setReportId(report.getReportId());
                    contentDTO.setReportContentId(null);
                    dailyReportContentService.insertDailyReportContent(contentDTO);
                    break;
                }
                case "delete": {
                    dailyReportContentService.deleteDailyReportContentByReportContentId(contentDTO.getReportContentId());
                    break;
                }
                default: {
                    dailyReportContentService.updateDailyReportContent(contentDTO);
                    break;
                }
            }
        });
        return i;
    }
}
