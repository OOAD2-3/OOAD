package com.ooad.demo.mapper;

import com.ooad.demo.entity.CClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    //================查找==========================
    /**
     * 通过id查找cclass表所有字段
     * @param id
     * @return CClass
     */
    CClass findById(Integer id);

    /**
     * 通过courseId查找表cclass所有字段
     * @param courseId
     * @return
     */
    List<CClass> findByCourseId(Integer courseId);

    /**
     * 通过courseId和班级名name查找cclass所有字段
     * @param courseId
     * @param name
     * @return CClass
     */
    CClass findByCourseIdAndCClassName(@Param("courseId") Integer courseId, @Param("name") String name);
    //================插入=========================

    /**
     * 通过courseId新增cclass记录
     * @param cClass
     * @return 新增的cclass记录主键
     */
    int insertCClass(CClass cClass);
}
