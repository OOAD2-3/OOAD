package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Round;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoundMapper {
    Round findById(Integer id);
    List<Round> findByCourseId(Integer courseId);
}
