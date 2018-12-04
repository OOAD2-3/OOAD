package com.ooad.demo.mapper;

import com.ooad.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
    User findById(Integer id);
}
