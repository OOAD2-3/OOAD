package com.ooad.demo.Entity;

import java.sql.Timestamp;

public class Seminar {
    //基本信息
    private int id;
    private int roundId;           //属于哪个round 默认为0 不属于任何一个
    private int courseId;          //属于哪个course
    private String topic;           //讨论课主题
    private String intro;            //讨论课介绍
    private boolean canVisible;   //是否可见
    private boolean hasShare;       //是否共享
    private Timestamp startTime;    //讨论课开始时间
    private boolean hasFinished;    //是否结束
    private boolean hasStarted;     //是否开始

    //规则
    private int teamNumLimit;
    private Timestamp reportDDL;
    private Timestamp signUpStartTime;
    private Timestamp signUpEndTime;

    //==================================================getter AND setter==================================================//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public boolean isCanVisible() {
        return canVisible;
    }

    public void setCanVisible(boolean canVisible) {
        this.canVisible = canVisible;
    }



    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public boolean isHasShare() {
        return hasShare;
    }

    public void setHasShare(boolean hasShare) {
        this.hasShare = hasShare;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public int getTeamNumLimit() {
        return teamNumLimit;
    }

    public void setTeamNumLimit(int teamNumLimit) {
        this.teamNumLimit = teamNumLimit;
    }

    public Timestamp getReportDDL() {
        return reportDDL;
    }

    public void setReportDDL(Timestamp reportDDL) {
        this.reportDDL = reportDDL;
    }

    public Timestamp getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(Timestamp signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public Timestamp getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(Timestamp signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }
}
