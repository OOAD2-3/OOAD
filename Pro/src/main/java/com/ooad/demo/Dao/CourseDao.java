package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Course;
import com.ooad.demo.Mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
    @Autowired
    CourseMapper courseMapper;

    /**
     * @Description:通过teacherId获取该teacher下的所有Course
     * @Author:17Wang
     * @Time:22:52 2018/11/27
    **/
    public List<Course> listByTeacherId(int teacherId) {
        List<Course> courses = courseMapper.findByTeacherId(teacherId);
    }
}
