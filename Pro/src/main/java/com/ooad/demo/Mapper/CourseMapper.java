package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    Course findById(Integer id);
    List<Course> findByTeacherId(Integer teacherId);
}
