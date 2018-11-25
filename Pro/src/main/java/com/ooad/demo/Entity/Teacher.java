package com.ooad.demo.Entity;

import java.util.List;

public class Teacher extends User{
    private int id;
    private String title;//职称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
