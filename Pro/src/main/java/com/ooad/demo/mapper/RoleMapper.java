package com.ooad.demo.mapper;

import com.ooad.demo.entity.security.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 21:01 2018/12/5
 * Description:
 */
@Mapper
@Repository
public interface RoleMapper {
    List<Integer> listRoleIdByMenuId(int menuId);
    Role getById(int id);
}
