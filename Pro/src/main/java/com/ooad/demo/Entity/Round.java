package com.ooad.demo.Entity;

public class Round {
    //基础信息
    private int id;
    private int courseId;           //所属课程id
    private int order;               //轮次
    private int calculatePreType;
    private int calculateQueType;
    private int calculateRepType;
    private int signUpNum;

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
}
