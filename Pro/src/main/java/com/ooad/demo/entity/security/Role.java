package com.ooad.demo.entity.security;

/**
 * @Author: 17Wang
 * @Date: 17:28 2018/12/5
 * @Description:
 */
public class Role {
    private int id;
    private String name;
    private String nameZW;

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
}
