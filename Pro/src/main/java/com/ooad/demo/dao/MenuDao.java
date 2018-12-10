package com.ooad.demo.dao;

import com.ooad.demo.entity.Menu;
import com.ooad.demo.entity.Role;
import com.ooad.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 21:00 2018/12/5
 * Description:
 */
@Component
public class MenuDao {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleDao roleDao;

    /**
     * Description: 返回所有的资源
     * @Author: 17Wang
     * @Time: 21:19 2018/12/5
    */
    public Menu getMenuRoleByMenuId(int menuId){
         return menuMapper.findMenuRoleByMenuId(menuId);
    }

    public List<Menu> listAllMenuRole(){
        return menuMapper.findAll();
    }
}
