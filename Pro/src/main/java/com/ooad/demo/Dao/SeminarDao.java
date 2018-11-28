package com.ooad.demo.Dao;

import com.ooad.demo.Mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeminarDao {
    @Autowired
    SeminarMapper seminarMapper;
}
