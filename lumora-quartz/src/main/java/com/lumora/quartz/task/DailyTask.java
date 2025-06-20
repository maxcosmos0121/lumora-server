package com.lumora.quartz.task;

import com.lumora.daily.service.IDailyExpenseService;
import com.lumora.daily.service.IDailyReportService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 日常记录定时任务
 */
@Component("dailyTask")
public class DailyTask {

    @Resource
    private IDailyReportService dailyReportService;

    @Resource
    private IDailyExpenseService dailyExpenseService;

    public void addDailyReport() {

        long start = System.currentTimeMillis();
        System.out.println("执行定时任务: " + start);

        dailyReportService.addDailyReportBatch();

        long end = System.currentTimeMillis();
        System.out.println("执行定时任务结束: " + end);
        System.out.println("耗时: " + (end - start) + " ms");
    }

    public void addDailyExpense() {

        long start = System.currentTimeMillis();
        System.out.println("执行定时任务: " + start);

        dailyExpenseService.addDailyExpenseBatch();

        long end = System.currentTimeMillis();
        System.out.println("执行定时任务结束: " + end);
        System.out.println("耗时: " + (end - start) + " ms");
    }

}
