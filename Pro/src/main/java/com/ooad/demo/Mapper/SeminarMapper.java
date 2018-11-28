package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Seminar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SeminarMapper {
    Seminar findById(Integer id);
    List<Seminar> findByCourseId(Integer courseId);
}
