package com.ooad.demo.Service;

import com.ooad.demo.Entity.User;
import com.ooad.demo.Mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public User listAllTeacher(int id){
        return teacherMapper.findById(id);
    }
}
