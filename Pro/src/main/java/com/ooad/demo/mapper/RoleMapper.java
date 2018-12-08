package com.ooad.demo.mapper;

import com.ooad.demo.entity.Role;
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
    //================查找==========================
    /**
     * 通过menuId查找role表的所有字段
     * @param menuId
     * @return  List<Integer>
     */
    List<Integer> listRoleIdByMenuId(int menuId);

    /**
     * 通过id查找role表的所有字段
     * @param id
     * @return  Role
     */
    Role getById(int id);
}
