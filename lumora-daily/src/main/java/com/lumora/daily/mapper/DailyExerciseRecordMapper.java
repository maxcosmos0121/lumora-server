package com.lumora.daily.mapper;

import java.util.List;
import com.lumora.daily.domain.DailyExerciseRecord;
import com.lumora.daily.vo.DailyExerciseRecordVo;

/**
 * 日常记录_运动记录Mapper接口
 *
 * @author leo
 * @date 2025-06-22
 */
public interface DailyExerciseRecordMapper
{
    /**
     * 查询日常记录_运动记录
     *
     * @param exerciseRecordId 日常记录_运动记录主键
     * @return 日常记录_运动记录
     */
    public DailyExerciseRecord selectDailyExerciseRecordByExerciseRecordId(Long exerciseRecordId);

    /**
     * 查询日常记录_运动记录列表
     *
     * @param dailyExerciseRecord 日常记录_运动记录
     * @return 日常记录_运动记录集合
     */
    public List<DailyExerciseRecord> selectDailyExerciseRecordList(DailyExerciseRecordVo dailyExerciseRecord);

    /**
     * 新增日常记录_运动记录
     *
     * @param dailyExerciseRecord 日常记录_运动记录
     * @return 结果
     */
    public int insertDailyExerciseRecord(DailyExerciseRecord dailyExerciseRecord);

    /**
     * 修改日常记录_运动记录
     *
     * @param dailyExerciseRecord 日常记录_运动记录
     * @return 结果
     */
    public int updateDailyExerciseRecord(DailyExerciseRecord dailyExerciseRecord);

    /**
     * 删除日常记录_运动记录
     *
     * @param exerciseRecordId 日常记录_运动记录主键
     * @return 结果
     */
    public int deleteDailyExerciseRecordByExerciseRecordId(Long exerciseRecordId);

    /**
     * 批量删除日常记录_运动记录
     *
     * @param exerciseRecordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDailyExerciseRecordByExerciseRecordIds(Long[] exerciseRecordIds);
}
