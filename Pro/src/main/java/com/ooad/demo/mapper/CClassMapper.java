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
    /**
     * 通过id查找表所有字段
     * @param id
     * @return CClass
     */
    CClass findById(Integer id);

    /**
     * 通过courseId查找表所有字段
     * @param courseId
     * @return
     */
    List<CClass> findByCourseId(Integer courseId);
}
