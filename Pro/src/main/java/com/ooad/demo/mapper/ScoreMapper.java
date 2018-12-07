package com.ooad.demo.mapper;

import com.ooad.demo.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 16:43 2018/12/2
 * @Modified by:
 */
@Mapper
@Repository
public interface ScoreMapper {
    //=============================查找=========================
    /**
     * 通过roundId seminarId teamId查找score表所有字段
     * @param roundId
     * @param seminarId
     * @param teamId
     * @return Score
     */
    Score findByRoundIdAndSeminarIdAndTeamId(@Param("roundId")Integer roundId,@Param("seminarId") Integer seminarId,
                                             @Param("teamId") Integer teamId);

    //=============================修改=========================
    /**
     * 通过Score修改表的pre_score字段
     * @param score
     */
    void updatePreScore(Score score);

    /**
     * 通过Score修改表的report_score字段
     * @param score
     */
    void updateReportScore(Score score);

    /**
     * 通过Score修改表的question_score字段
     * @param score
     */
    void updateQuestionScore(Score score);

    /**
     * 通过Score修改表的total_score字段
     * @param score
     */
    void updateTotalScore(Score score);
}
