package com.ooad.demo.service;

import com.ooad.demo.entity.User;
import com.ooad.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * @Description:登录判断
     * @Author:17Wang
     * @Time:20:34 2018/12/4
    */
    public boolean login(String userId,String password){
        User user=userMapper.findByUserId(userId);
        if(user.getPassword()==password){
            return true;
        }
        //

        return false;
    }
}
