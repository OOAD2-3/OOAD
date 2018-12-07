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
    //========================================查找===============================
    /**
     * 通过seminarId和teamId查找question表的所有字段
     * @param seminarId
     * @param teamId
     * @return  List<Question>
     */
    List<Question> findBySeminarIdAndTeamId(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId);

    /**
     * 通过teamId查找question表的所有字段
     * @param teamId
     * @return  List<Question>
     */
    List<Question> findByTeamId(Integer teamId);
    //========================================修改===============================
    /**
     * 通过Question修改表的question_score
     * @param question
     */
    void updateQuestionScore(Question question);
    //========================================新增===============================
    /**
     * 通过seminarId teamId questionScore新增表记录
     * @param seminarId
     * @param teamId
     * @param questionScore
     */
    void insertBySeminarIdAndTeamIdAndQuestionScore(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId, @Param("questionScore") Float questionScore);
}
