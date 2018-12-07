package com.ooad.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Round {
    private int id;
    /**
     * 所属课程id
     */
    private int courseId;
    /**
     * 第几轮次
     */
    private int order;
    private int calculatePreType;
    private int calculateQueType;
    private int calculateRepType;
    private int signUpNum;

    /**
     * 轮次下的讨论课
     */
    private List<Seminar> seminars=new ArrayList<>();
    /**
     * 轮次的课程信息
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getCalculatePreType() {
        return calculatePreType;
    }

    public void setCalculatePreType(int calculatePreType) {
        this.calculatePreType = calculatePreType;
    }

    public int getCalculateQueType() {
        return calculateQueType;
    }

    public void setCalculateQueType(int calculateQueType) {
        this.calculateQueType = calculateQueType;
    }

    public int getCalculateRepType() {
        return calculateRepType;
    }

    public void setCalculateRepType(int calculateRepType) {
        this.calculateRepType = calculateRepType;
    }

    public int getSignUpNum() {
        return signUpNum;
    }

    public void setSignUpNum(int signUpNum) {
        this.signUpNum = signUpNum;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
