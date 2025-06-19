package com.lumora.web.controller.daily;

import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.dto.DailyReportDTO;
import com.lumora.daily.service.IDailyReportService;
import com.lumora.common.annotation.Log;
import com.lumora.common.core.controller.BaseController;
import com.lumora.common.core.domain.AjaxResult;
import com.lumora.common.core.page.TableDataInfo;
import com.lumora.common.enums.BusinessType;
import com.lumora.common.utils.poi.ExcelUtil;
import com.lumora.daily.vo.DailyReportReqVo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日常记录_每日日报Controller
 *
 * @author Leo
 * @date 2025-06-11
 */
@RestController
@RequestMapping("/daily/report")
public class DailyReportController extends BaseController {
    @Autowired
    private IDailyReportService dailyReportService;

    /**
     * 查询日常记录_每日日报列表
     */
    @PreAuthorize("@ss.hasPermi('daily:report:list')")
    @GetMapping("/list")
    public TableDataInfo list(DailyReportDTO dailyReport) {
        startPage();
        List<DailyReport> list = dailyReportService.selectDailyReportList(dailyReport);
        return getDataTable(list);
    }

    /**
     * 导出日常记录_每日日报列表
     */
    @PreAuthorize("@ss.hasPermi('daily:report:export')")
    @Log(title = "日常记录_每日日报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DailyReportDTO dailyReport) {
        List<DailyReport> list = dailyReportService.selectDailyReportList(dailyReport);
        ExcelUtil<DailyReport> util = new ExcelUtil<DailyReport>(DailyReport.class);
        util.exportExcel(response, list, "日常记录_每日日报数据");
    }

    /**
     * 获取日常记录_每日日报详细信息
     */
    @PreAuthorize("@ss.hasPermi('daily:report:query')")
    @GetMapping(value = "/{reportId}")
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId) {
        return success(dailyReportService.selectDailyReportByReportId(reportId));
    }

    /**
     * 新增日常记录_每日日报
     */
    @PreAuthorize("@ss.hasPermi('daily:report:add')")
    @Log(title = "日常记录_每日日报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DailyReport dailyReport) {
        return toAjax(dailyReportService.insertDailyReport(dailyReport));
    }

    /**
     * 修改日常记录_每日日报
     */
    @PreAuthorize("@ss.hasPermi('daily:report:edit')")
    @Log(title = "日常记录_每日日报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DailyReport dailyReport) {
        return toAjax(dailyReportService.updateDailyReport(dailyReport));
    }

    /**
     * 删除日常记录_每日日报
     */
    @PreAuthorize("@ss.hasPermi('daily:report:remove')")
    @Log(title = "日常记录_每日日报", businessType = BusinessType.DELETE)
    @DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds) {
        return toAjax(dailyReportService.deleteDailyReportByReportIds(reportIds));
    }

    /**
     * 新增日常记录_每日日报
     */
    @PreAuthorize("@ss.hasPermi('daily:report:submit')")
    @Log(title = "日常记录_每日日报", businessType = BusinessType.INSERT)
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody DailyReportReqVo dailyReport) {
        return toAjax(dailyReportService.submit(dailyReport));
    }
}
