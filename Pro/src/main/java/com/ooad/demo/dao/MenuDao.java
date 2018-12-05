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
    public List<Menu> listAll(){
        List<Menu> menus=menuMapper.listAll();
        for(Menu menu:menus){
            List<Integer> roleId=roleDao.listRoleIdByMenuId(menu.getId());
            List<Role> roles=new ArrayList<>();
            for(int i:roleId){
                Role role=roleDao.getById(i);
                if(role!=null) {
                    roles.add(role);
                }
            }
            menu.setRoles(roles);
        }
        return menus;
    }
}
