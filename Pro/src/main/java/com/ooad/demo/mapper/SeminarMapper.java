package com.ooad.demo.mapper;

import com.ooad.demo.entity.Seminar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SeminarMapper {
    Seminar findById(Integer id);
    List<Seminar> findByCourseId(Integer courseId);
    List<Seminar> findByRoundId(Integer roundId);
}