package com.ooad.demo.Controller;

import com.ooad.demo.Dao.CourseDao;
import com.ooad.demo.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseDao courseDao;

    @RequestMapping(value = "/test")
    public List<Course> listByTeacherId(){
        return courseDao.findByTeacherId(1);
    }
}
