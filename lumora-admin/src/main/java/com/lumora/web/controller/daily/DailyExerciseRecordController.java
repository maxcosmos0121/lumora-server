package com.lumora.web.controller.daily;

import java.util.List;

import com.lumora.daily.vo.DailyExerciseRecordVo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lumora.common.annotation.Log;
import com.lumora.common.core.controller.BaseController;
import com.lumora.common.core.domain.AjaxResult;
import com.lumora.common.enums.BusinessType;
import com.lumora.daily.domain.DailyExerciseRecord;
import com.lumora.daily.service.IDailyExerciseRecordService;
import com.lumora.common.utils.poi.ExcelUtil;
import com.lumora.common.core.page.TableDataInfo;

/**
 * 日常记录_运动记录Controller
 *
 * @author leo
 * @date 2025-06-22
 */
@RestController
@RequestMapping("/daily/exerciseRecord")
public class DailyExerciseRecordController extends BaseController {
    @Autowired
    private IDailyExerciseRecordService dailyExerciseRecordService;

    /**
     * 查询日常记录_运动记录列表
     */
    @PreAuthorize("@ss.hasPermi('daily:exerciseRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(DailyExerciseRecordVo dailyExerciseRecord) {
        startPage();
        List<DailyExerciseRecord> list = dailyExerciseRecordService.selectDailyExerciseRecordList(dailyExerciseRecord);
        return getDataTable(list);
    }

    /**
     * 导出日常记录_运动记录列表
     */
    @PreAuthorize("@ss.hasPermi('daily:exerciseRecord:export')")
    @Log(title = "日常记录_运动记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DailyExerciseRecordVo dailyExerciseRecord) {
        List<DailyExerciseRecord> list = dailyExerciseRecordService.selectDailyExerciseRecordList(dailyExerciseRecord);
        ExcelUtil<DailyExerciseRecord> util = new ExcelUtil<DailyExerciseRecord>(DailyExerciseRecord.class);
        util.exportExcel(response, list, "日常记录_运动记录数据");
    }

    /**
     * 获取日常记录_运动记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('daily:exerciseRecord:query')")
    @GetMapping(value = "/{exerciseRecordId}")
    public AjaxResult getInfo(@PathVariable("exerciseRecordId") Long exerciseRecordId) {
        return success(dailyExerciseRecordService.selectDailyExerciseRecordByExerciseRecordId(exerciseRecordId));
    }

    /**
     * 新增日常记录_运动记录
     */
    @PreAuthorize("@ss.hasPermi('daily:exerciseRecord:add')")
    @Log(title = "日常记录_运动记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DailyExerciseRecord dailyExerciseRecord) {
        return toAjax(dailyExerciseRecordService.insertDailyExerciseRecord(dailyExerciseRecord));
    }

    /**
     * 修改日常记录_运动记录
     */
    @PreAuthorize("@ss.hasPermi('daily:exerciseRecord:edit')")
    @Log(title = "日常记录_运动记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DailyExerciseRecord dailyExerciseRecord) {
        return toAjax(dailyExerciseRecordService.updateDailyExerciseRecord(dailyExerciseRecord));
    }

    /**
     * 删除日常记录_运动记录
     */
    @PreAuthorize("@ss.hasPermi('daily:exerciseRecord:remove')")
    @Log(title = "日常记录_运动记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{exerciseRecordIds}")
    public AjaxResult remove(@PathVariable Long[] exerciseRecordIds) {
        return toAjax(dailyExerciseRecordService.deleteDailyExerciseRecordByExerciseRecordIds(exerciseRecordIds));
    }
}
