package com.ooad.demo.dao;

import com.ooad.demo.entity.Role;
import com.ooad.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 22:24 2018/12/5
 * Description:
 */
@Component
public class RoleDao {
    @Autowired
    RoleMapper roleMapper;

    Role getById(int id){
        return roleMapper.getById(id);
    }

    List<Integer> listRoleIdByMenuId(int menuId){
        return roleMapper.listRoleIdByMenuId(menuId);
    }
}
