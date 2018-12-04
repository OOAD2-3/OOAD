package com.ooad.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Round {
    //基础信息
    private int id;
    private int courseId;           //所属课程id
    private int order;               //轮次
    private int calculatePreType;
    private int calculateQueType;
    private int calculateRepType;
    private int signUpNum;

    //关系
    private List<Seminar> seminars=new ArrayList<>();

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

    //关系
    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
}
