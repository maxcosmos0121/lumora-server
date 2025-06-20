package com.lumora.daily.service.impl;

import java.util.List;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.lumora.common.annotation.DataScope;
import com.lumora.common.core.domain.entity.SysUser;
import com.lumora.common.utils.DateUtils;
import com.lumora.daily.domain.DailyExpenseDetails;
import com.lumora.daily.domain.DailyReport;
import com.lumora.daily.dto.DailyExpenseDetailsDTO;
import com.lumora.daily.dto.DailyReportContentDTO;
import com.lumora.daily.service.IDailyExpenseDetailsService;
import com.lumora.daily.vo.DailyExpenseReqVo;
import com.lumora.daily.vo.DailyExpenseRespVo;
import com.lumora.daily.vo.DailyExpenseVo;
import com.lumora.system.service.ISysUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lumora.daily.mapper.DailyExpenseMapper;
import com.lumora.daily.domain.DailyExpense;
import com.lumora.daily.service.IDailyExpenseService;

/**
 * 日常记录_每日支出Service业务层处理
 *
 * @author leo
 * @date 2025-06-20
 */
@Service
public class DailyExpenseServiceImpl implements IDailyExpenseService {
    @Autowired
    private DailyExpenseMapper dailyExpenseMapper;

    @Resource
    private IDailyExpenseDetailsService dailyExpenseDetailsService;

    @Resource
    private ISysUserService sysUserService;

    /**
     * 查询日常记录_每日支出
     *
     * @param expenseId 日常记录_每日支出主键
     * @return 日常记录_每日支出
     */
    @Override
    public DailyExpenseRespVo selectDailyExpenseByExpenseId(Long expenseId) {
        DailyExpenseRespVo dailyExpenseRespVo = new DailyExpenseRespVo();
        DailyExpense dailyExpense = dailyExpenseMapper.selectDailyExpenseByExpenseId(expenseId);
        DailyExpenseDetails temp = new DailyExpenseDetails();
        temp.setExpenseId(expenseId);
        List<DailyExpenseDetails> dailyExpenseDetails = dailyExpenseDetailsService.selectDailyExpenseDetailsList(temp);
        dailyExpenseRespVo.setDailyExpense(dailyExpense);
        dailyExpenseRespVo.setDailyExpenseDetails(dailyExpenseDetails);
        return dailyExpenseRespVo;
    }

    /**
     * 查询日常记录_每日支出列表
     *
     * @param dailyExpense 日常记录_每日支出
     * @return 日常记录_每日支出
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<DailyExpense> selectDailyExpenseList(DailyExpenseVo dailyExpense) {
        return dailyExpenseMapper.selectDailyExpenseList(dailyExpense);
    }

    /**
     * 新增日常记录_每日支出
     *
     * @param dailyExpense 日常记录_每日支出
     * @return 结果
     */
    @Override
    public int insertDailyExpense(DailyExpense dailyExpense) {
        dailyExpense.setCreateTime(DateUtils.getNowDate());
        return dailyExpenseMapper.insertDailyExpense(dailyExpense);
    }

    /**
     * 修改日常记录_每日支出
     *
     * @param dailyExpense 日常记录_每日支出
     * @return 结果
     */
    @Override
    public int updateDailyExpense(DailyExpense dailyExpense) {
        dailyExpense.setUpdateTime(DateUtils.getNowDate());
        return dailyExpenseMapper.updateDailyExpense(dailyExpense);
    }

    /**
     * 批量删除日常记录_每日支出
     *
     * @param expenseIds 需要删除的日常记录_每日支出主键
     * @return 结果
     */
    @Override
    public int deleteDailyExpenseByExpenseIds(Long[] expenseIds) {
        return dailyExpenseMapper.deleteDailyExpenseByExpenseIds(expenseIds);
    }

    /**
     * 删除日常记录_每日支出信息
     *
     * @param expenseId 日常记录_每日支出主键
     * @return 结果
     */
    @Override
    public int deleteDailyExpenseByExpenseId(Long expenseId) {
        return dailyExpenseMapper.deleteDailyExpenseByExpenseId(expenseId);
    }

    @Override
    public int save(DailyExpenseReqVo dailyExpense) {
        DailyExpense expense = dailyExpense.getDailyExpense();
        int i = this.updateDailyExpense(expense);
        List<DailyExpenseDetailsDTO> dailyExpenseDetails = dailyExpense.getDailyExpenseDetails();
        dailyExpenseDetails.forEach(contentDTO -> {
            switch (contentDTO.getStatus()) {
                case "add": {
                    contentDTO.setExpenseId(expense.getExpenseId());
                    contentDTO.setExpenseDetailsId(null);
                    dailyExpenseDetailsService.insertDailyExpenseDetails(contentDTO);
                    break;
                }
                case "delete": {
                    dailyExpenseDetailsService.deleteDailyExpenseDetailsByExpenseDetailsId(contentDTO.getExpenseDetailsId());
                    break;
                }
                default: {
                    dailyExpenseDetailsService.updateDailyExpenseDetails(contentDTO);
                    break;
                }
            }
        });
        return i;
    }

    @Override
    public int submit(DailyExpenseReqVo dailyExpense) {
        dailyExpense.getDailyExpense().setExpenseStatus("Y");
        return this.save(dailyExpense);
    }

    @Override
    public void addDailyExpenseBatch() {
        List<SysUser> sysUsers = sysUserService.selectUsers();

        DateTime now = DateUtil.date();
        int week = DateUtil.dayOfWeek(now);
        week = (week == 1) ? 7 : week - 1;

        DailyExpense dailyExpense = new DailyExpense();
        dailyExpense.setDay(now);
        dailyExpense.setWeek(String.valueOf(week));

        sysUsers.forEach(user -> {
            if ("admin".equals(user.getUserName())) {
                return;
            }
            dailyExpense.setCreateBy(user.getUserName());

            this.insertDailyExpense(dailyExpense);
        });
    }
}
