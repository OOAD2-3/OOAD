package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CourseMapper {
    Course findById(int id);
    List<Course> findByTeacherId(int teacherId);
}
