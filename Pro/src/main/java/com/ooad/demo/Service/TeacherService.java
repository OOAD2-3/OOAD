package com.ooad.demo.Service;

import com.ooad.demo.Dao.TeacherDao;
import com.ooad.demo.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public Teacher listAllTeacher(int id){
        return teacherDao.findById(id);
    }
}
