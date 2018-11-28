package com.ooad.demo.Dao;

import com.ooad.demo.Mapper.RoundMapper;
import com.ooad.demo.Mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoundDao {
    @Autowired
    RoundMapper roundMapper;

    @Autowired
    SeminarMapper seminarMapper;
}
