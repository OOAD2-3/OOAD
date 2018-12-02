package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Score;
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
    Score findByRoundIdAndSeminarIdAndTeamId(@Param("roundId")Integer roundId,@Param("seminarId") Integer seminarId,
                                             @Param("teamId") Integer teamId);

    //=============================修改=========================
    void updatePreScore(Score score);
    void updateReportScore(Score score);
    void updateQuestionScore(Score score);
    void updateTotalScore(Score score);
}
