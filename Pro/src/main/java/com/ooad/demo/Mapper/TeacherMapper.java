package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
    User findById(Integer id);
}
