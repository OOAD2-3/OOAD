package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherDao {
    Teacher findById(Integer id);
}
