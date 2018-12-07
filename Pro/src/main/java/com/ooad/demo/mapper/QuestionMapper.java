package com.ooad.demo.mapper;

import com.ooad.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 8:56 2018/11/30
 * @Modified by:
 */
@Mapper
@Repository
public interface QuestionMapper {
    /**
     *
     * @param seminarId
     * @param teamId
     * @return
     */
    List<Question> findBySeminarIdAndTeamId(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId);

    /**
     *
     * @param teamId
     * @return
     */
    List<Question> findByTeamId(Integer teamId);

    /**
     *
     * @param question
     */
    void updateQuestionScore(Question question);

    /**
     *
     * @param seminarId
     * @param teamId
     * @param questionScore
     */
    void insertBySeminarIdAndTeamIdAndQuestionScore(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId, @Param("questionScore") Float questionScore);
}
