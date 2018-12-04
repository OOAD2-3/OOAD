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
    Round findById(Integer id);
    List<Round> findByCourseId(Integer courseId);
}
