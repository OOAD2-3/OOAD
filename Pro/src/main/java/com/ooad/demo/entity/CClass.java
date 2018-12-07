package com.ooad.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class CClass {
    //基本信息
    private int id;
    /**
     * 属于哪个课程
     */
    private int courseId;
    private String name;
    private String place;
    private String time;

    //关系
    /**
     * 班级下的队伍
     */
    private List<Team> teams = new ArrayList<>();
    /**
     * 班级下的讨论课
     */
    private List<Seminar> seminars = new ArrayList<>();
    /**
     * 班级所属的课程
     */
    private Course course;

    //==================================================getter AND setter==================================================//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
}
