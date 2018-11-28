package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.CClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CClassMapper {
    CClass findById(Integer id);
    List<CClass> findByCourseId(Integer courseId);
}
