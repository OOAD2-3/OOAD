package com.ooad.demo.mapper;

import com.ooad.demo.entity.CClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CClassMapper {
    CClass findById(Integer id);
    List<CClass> findByCourseId(Integer courseId);
}
