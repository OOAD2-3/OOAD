package com.ooad.demo.service;

import com.ooad.demo.dao.MenuDao;
import com.ooad.demo.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 17:47 2018/12/5
 * @Description:
 */
@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    public Menu listMenuRoleByMenuId(int menuId){
        return menuDao.getMenuRoleByMenuId(menuId);
    }
}
