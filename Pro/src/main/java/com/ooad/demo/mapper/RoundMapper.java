package com.ooad.demo.mapper;

import com.ooad.demo.entity.Round;
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
public interface RoundMapper {
    //================查找==========================
    /**
     * 通过id查找round表的所有字段
     * @param id
     * @return  Round
     */
    Round findById(Integer id);

    /**
     * 通过courseId查找round表的所有字段
     * @param courseId
     * @return  List<Round>
     */
    List<Round> findByCourseId(Integer courseId);
}
