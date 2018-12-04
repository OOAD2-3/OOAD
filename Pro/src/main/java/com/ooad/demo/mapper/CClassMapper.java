package com.ooad.demo.mapper;

import com.ooad.demo.entity.CClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Mapper
@Repository
public interface CClassMapper {
    CClass findById(Integer id);
    List<CClass> findByCourseId(Integer courseId);
}
