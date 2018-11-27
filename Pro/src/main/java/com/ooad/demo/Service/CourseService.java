package com.ooad.demo.Service;

import com.ooad.demo.Mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

}
