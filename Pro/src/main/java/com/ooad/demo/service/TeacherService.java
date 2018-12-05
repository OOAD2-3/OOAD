package com.ooad.demo.service;

import com.ooad.demo.entity.User;
import com.ooad.demo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public User listAllTeacher(int id){
        return teacherMapper.findById(id);
    }
}
