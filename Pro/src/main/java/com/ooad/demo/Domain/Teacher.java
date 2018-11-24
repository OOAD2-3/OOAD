package com.ooad.demo.Domain;

import java.util.List;

public class Teacher extends User{
    private int id;
    private String title;//职称
    private List<Course> courses;//教师拥有的课程

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
