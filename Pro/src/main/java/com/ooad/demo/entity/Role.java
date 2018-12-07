package com.ooad.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 17:28 2018/12/5
 * @Description:
 */
public class Role {
    private int id;
    private String name;
    private String nameZW;

    List<User> users = new ArrayList<>();
    List<Menu> menus = new ArrayList<>();

    /* ==================================================getter AND setter==================================================*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZW() {
        return nameZW;
    }

    public void setNameZW(String nameZW) {
        this.nameZW = nameZW;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
