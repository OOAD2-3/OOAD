package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
    Teacher findById(Integer id);
}
