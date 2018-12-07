package com.ooad.demo.mapper;

import com.ooad.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 17:50 2018/12/5
 * @Description:
 */
@Mapper
@Repository
public interface MenuMapper {
    //================查找==========================
    /**
     * 查找表所有字段
     * @return List<Menu>
     */
    List<Menu> listAll();

}
