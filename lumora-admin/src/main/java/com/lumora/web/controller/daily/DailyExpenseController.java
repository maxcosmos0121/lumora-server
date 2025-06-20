package com.lumora.web.controller.daily;

import java.util.List;

import com.lumora.daily.vo.DailyExpenseReqVo;
import com.lumora.daily.vo.DailyExpenseVo;
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
import com.lumora.daily.domain.DailyExpense;
import com.lumora.daily.service.IDailyExpenseService;
import com.lumora.common.utils.poi.ExcelUtil;
import com.lumora.common.core.page.TableDataInfo;

/**
 * 日常记录_每日支出Controller
 *
 * @author leo
 * @date 2025-06-20
 */
@RestController
@RequestMapping("/daily/expense")
public class DailyExpenseController extends BaseController
{
    @Autowired
    private IDailyExpenseService dailyExpenseService;

    /**
     * 查询日常记录_每日支出列表
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:list')")
    @GetMapping("/list")
    public TableDataInfo list(DailyExpenseVo dailyExpense)
    {
        startPage();
        List<DailyExpense> list = dailyExpenseService.selectDailyExpenseList(dailyExpense);
        return getDataTable(list);
    }

    /**
     * 导出日常记录_每日支出列表
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:export')")
    @Log(title = "日常记录_每日支出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DailyExpenseVo dailyExpense)
    {
        List<DailyExpense> list = dailyExpenseService.selectDailyExpenseList(dailyExpense);
        ExcelUtil<DailyExpense> util = new ExcelUtil<DailyExpense>(DailyExpense.class);
        util.exportExcel(response, list, "日常记录_每日支出数据");
    }

    /**
     * 获取日常记录_每日支出详细信息
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:query')")
    @GetMapping(value = "/{expenseId}")
    public AjaxResult getInfo(@PathVariable("expenseId") Long expenseId)
    {
        return success(dailyExpenseService.selectDailyExpenseByExpenseId(expenseId));
    }

    /**
     * 新增日常记录_每日支出
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:add')")
    @Log(title = "日常记录_每日支出", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DailyExpense dailyExpense)
    {
        return toAjax(dailyExpenseService.insertDailyExpense(dailyExpense));
    }

    /**
     * 修改日常记录_每日支出
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:edit')")
    @Log(title = "日常记录_每日支出", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DailyExpense dailyExpense)
    {
        return toAjax(dailyExpenseService.updateDailyExpense(dailyExpense));
    }

    /**
     * 删除日常记录_每日支出
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:remove')")
    @Log(title = "日常记录_每日支出", businessType = BusinessType.DELETE)
	@DeleteMapping("/{expenseIds}")
    public AjaxResult remove(@PathVariable Long[] expenseIds)
    {
        return toAjax(dailyExpenseService.deleteDailyExpenseByExpenseIds(expenseIds));
    }

    /**
     * 日常记录_每日支出_保存
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:save')")
    @Log(title = "日常记录_每日支出_保存", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    public AjaxResult save(@RequestBody DailyExpenseReqVo dailyExpense)
    {
        return toAjax(dailyExpenseService.save(dailyExpense));
    }

    /**
     * 日常记录_每日支出_提交
     */
    @PreAuthorize("@ss.hasPermi('daily:expense:submit')")
    @Log(title = "日常记录_每日支出_提交", businessType = BusinessType.INSERT)
    @PostMapping("submit")
    public AjaxResult submit(@RequestBody DailyExpenseReqVo dailyExpense)
    {
        return toAjax(dailyExpenseService.submit(dailyExpense));
    }

}
