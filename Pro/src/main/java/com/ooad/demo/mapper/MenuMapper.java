package com.ooad.demo.mapper;

import com.ooad.demo.entity.security.Menu;
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
    List<Menu> listMenu();
}
