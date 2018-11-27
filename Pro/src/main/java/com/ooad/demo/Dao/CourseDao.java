package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    List<Course> findByTeacherId(int teacherId);
    Course findById(int id);
}
