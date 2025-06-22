package com.lumora.daily.service.impl;

import java.util.List;

import com.lumora.common.annotation.DataScope;
import com.lumora.common.utils.DateUtils;
import com.lumora.daily.vo.DailyExerciseRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lumora.daily.mapper.DailyExerciseRecordMapper;
import com.lumora.daily.domain.DailyExerciseRecord;
import com.lumora.daily.service.IDailyExerciseRecordService;

/**
 * 日常记录_运动记录Service业务层处理
 *
 * @author leo
 * @date 2025-06-22
 */
@Service
public class DailyExerciseRecordServiceImpl implements IDailyExerciseRecordService
{
    @Autowired
    private DailyExerciseRecordMapper dailyExerciseRecordMapper;

    /**
     * 查询日常记录_运动记录
     *
     * @param exerciseRecordId 日常记录_运动记录主键
     * @return 日常记录_运动记录
     */
    @Override
    public DailyExerciseRecord selectDailyExerciseRecordByExerciseRecordId(Long exerciseRecordId)
    {
        return dailyExerciseRecordMapper.selectDailyExerciseRecordByExerciseRecordId(exerciseRecordId);
    }

    /**
     * 查询日常记录_运动记录列表
     *
     * @param dailyExerciseRecord 日常记录_运动记录
     * @return 日常记录_运动记录
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<DailyExerciseRecord> selectDailyExerciseRecordList(DailyExerciseRecordVo dailyExerciseRecord)
    {
        return dailyExerciseRecordMapper.selectDailyExerciseRecordList(dailyExerciseRecord);
    }

    /**
     * 新增日常记录_运动记录
     *
     * @param dailyExerciseRecord 日常记录_运动记录
     * @return 结果
     */
    @Override
    public int insertDailyExerciseRecord(DailyExerciseRecord dailyExerciseRecord)
    {
        dailyExerciseRecord.setCreateTime(DateUtils.getNowDate());
        return dailyExerciseRecordMapper.insertDailyExerciseRecord(dailyExerciseRecord);
    }

    /**
     * 修改日常记录_运动记录
     *
     * @param dailyExerciseRecord 日常记录_运动记录
     * @return 结果
     */
    @Override
    public int updateDailyExerciseRecord(DailyExerciseRecord dailyExerciseRecord)
    {
        dailyExerciseRecord.setUpdateTime(DateUtils.getNowDate());
        return dailyExerciseRecordMapper.updateDailyExerciseRecord(dailyExerciseRecord);
    }

    /**
     * 批量删除日常记录_运动记录
     *
     * @param exerciseRecordIds 需要删除的日常记录_运动记录主键
     * @return 结果
     */
    @Override
    public int deleteDailyExerciseRecordByExerciseRecordIds(Long[] exerciseRecordIds)
    {
        return dailyExerciseRecordMapper.deleteDailyExerciseRecordByExerciseRecordIds(exerciseRecordIds);
    }

    /**
     * 删除日常记录_运动记录信息
     *
     * @param exerciseRecordId 日常记录_运动记录主键
     * @return 结果
     */
    @Override
    public int deleteDailyExerciseRecordByExerciseRecordId(Long exerciseRecordId)
    {
        return dailyExerciseRecordMapper.deleteDailyExerciseRecordByExerciseRecordId(exerciseRecordId);
    }
}
