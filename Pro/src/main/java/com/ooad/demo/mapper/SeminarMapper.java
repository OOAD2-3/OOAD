package com.ooad.demo.mapper;

import com.ooad.demo.entity.Seminar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Mapper
@Repository
public interface SeminarMapper {
    //=======================查找===================
    /**
     * 通过id查找表的所有字段
     * @param id
     * @return Seminar
     */
    Seminar findById(Integer id);

    /**
     * 通过courseId查找表的所有字段
     * @param courseId
     * @return List<Seminar>
     */
    List<Seminar> findByCourseId(Integer courseId);

    /**
     * 通过roundId查找表的所有字段
     * @param roundId
     * @return List<Seminar>
     */
    List<Seminar> findByRoundId(Integer roundId);
}
