package com.ooad.demo.mapper;

import com.ooad.demo.entity.security.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Mapper
@Repository
public interface TeacherMapper {
    User findById(Integer id);
}
