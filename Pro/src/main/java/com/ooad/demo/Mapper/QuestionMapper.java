package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Question;
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

    //=============================查找======================================

    List<Question> findBySeminarIdAndTeamId(@Param("seminarId") Integer seminarId,@Param("teamId") Integer teamId);
    List<Question> findByTeamId(Integer teamId);

    //=============================修改======================================
    void updateQuestionScore(Question question);

    //=============================新增======================================
    void insertBySeminarIdAndTeamIdAndQuestionScore(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId, @Param("questionScore") Float questionScore);
}
