package com.ooad.demo.Entity;

import java.sql.Timestamp;

public class Course {
    //基本信息
    private int id;
    private int teacherId;              //属于哪个老师
    private String name;
    private String intro;
    private boolean isShareTeam;
    private boolean isShareSeminar;
    private int masterCourseId;

    //课程规则
    private int minTeamMember;
    private int maxTeamMember;
    private Timestamp startTeamTime;
    private Timestamp endTeamTime;
    private int presentationWeight;
    private int questionWeight;
    private int reportWeight;
    private int roundNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public boolean isShareTeam() {
        return isShareTeam;
    }

    public void setShareTeam(boolean shareTeam) {
        isShareTeam = shareTeam;
    }

    public boolean isShareSeminar() {
        return isShareSeminar;
    }

    public void setShareSeminar(boolean shareSeminar) {
        isShareSeminar = shareSeminar;
    }

    public int getMasterCourseId() {
        return masterCourseId;
    }

    public void setMasterCourseId(int masterCourseId) {
        this.masterCourseId = masterCourseId;
    }

    public int getMinTeamMember() {
        return minTeamMember;
    }

    public void setMinTeamMember(int minTeamMember) {
        this.minTeamMember = minTeamMember;
    }

    public int getMaxTeamMember() {
        return maxTeamMember;
    }

    public void setMaxTeamMember(int maxTeamMember) {
        this.maxTeamMember = maxTeamMember;
    }

    public Timestamp getStartTeamTime() {
        return startTeamTime;
    }

    public void setStartTeamTime(Timestamp startTeamTime) {
        this.startTeamTime = startTeamTime;
    }

    public Timestamp getEndTeamTime() {
        return endTeamTime;
    }

    public void setEndTeamTime(Timestamp endTeamTime) {
        this.endTeamTime = endTeamTime;
    }

    public int getPresentationWeight() {
        return presentationWeight;
    }

    public void setPresentationWeight(int presentationWeight) {
        this.presentationWeight = presentationWeight;
    }

    public int getQuestionWeight() {
        return questionWeight;
    }

    public void setQuestionWeight(int questionWeight) {
        this.questionWeight = questionWeight;
    }

    public int getReportWeight() {
        return reportWeight;
    }

    public void setReportWeight(int reportWeight) {
        this.reportWeight = reportWeight;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
