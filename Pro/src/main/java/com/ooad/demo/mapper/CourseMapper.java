package com.ooad.demo.mapper;

import com.ooad.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    Course findById(Integer id);
    List<Course> findByTeacherId(Integer teacherId);
}
