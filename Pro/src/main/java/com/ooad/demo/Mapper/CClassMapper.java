package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.CClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CClassMapper {
    CClass findById(Integer id);
    List<CClass> findByCourseId(Integer courseId);
}
