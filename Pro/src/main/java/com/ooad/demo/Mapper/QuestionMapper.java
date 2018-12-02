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
    Question findById(Integer id);
    List<Question> findBySeminarIdAndTeamId(@Param("seminarId") Integer seminarId,@Param("teamId") Integer teamId);
    List<Question> findByTeamId(Integer teamId);
}
