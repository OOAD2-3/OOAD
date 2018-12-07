package com.ooad.demo.mapper;

import com.ooad.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Mapper
@Repository
public interface UserMapper {
    //======================查找=====================
    /**
     * 通过id查找表的所有字段
     * @param id
     * @return User
     */
    User findById(int id);

    /**
     * 通过userId查找表的所有字段
     * @param userId
     * @return User
     */
    User findByUserId(String userId);
}
