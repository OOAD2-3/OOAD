package com.ooad.demo.mapper;

import com.ooad.demo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Mapper
@Repository
public interface CourseMapper {
    //================查找==========================
    /**
     * 通过id查找表所有字段
     * @param id
     * @return Course
     */
    Course findById(Integer id);

    /**
     * 通过teacherId查找表所有字段
     * @param teacherId
     * @return List<Course>
     */
    List<Course> findByTeacherId(Integer teacherId);

    /**
     * 删除课程
     * @param id
     * @throws SQLException
     */
    void deleteById(int id) throws SQLException;
}
