package com.ooad.demo.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Course {
    //基本信息
    private int id;
    private int teacherId;              //属于哪个老师
    private int masterCourseId;
    private String name;
    private String intro;
    private boolean shareTeam;
    private boolean shareSeminar;

    //课程规则
    private int minTeamMember;
    private int maxTeamMember;
    private Timestamp startTeamTime;
    private Timestamp endTeamTime;
    private double presentationWeight;
    private double questionWeight;
    private double reportWeight;
    private int roundNumber;

    //关系
    private List<CClass> cClasses;
    private List<Seminar> seminars;
    private List<Round> rounds;

    //==================================================getter AND setter==================================================//

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

    public int getMasterCourseId() {
        return masterCourseId;
    }

    public void setMasterCourseId(int masterCourseId) {
        this.masterCourseId = masterCourseId;
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
        return shareTeam;
    }

    public void setShareTeam(boolean shareTeam) {
        this.shareTeam = shareTeam;
    }

    public boolean isShareSeminar() {
        return shareSeminar;
    }

    public void setShareSeminar(boolean shareSeminar) {
        this.shareSeminar = shareSeminar;
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

    public double getPresentationWeight() {
        return presentationWeight;
    }

    public void setPresentationWeight(double presentationWeight) {
        this.presentationWeight = presentationWeight;
    }

    public double getQuestionWeight() {
        return questionWeight;
    }

    public void setQuestionWeight(double questionWeight) {
        this.questionWeight = questionWeight;
    }

    public double getReportWeight() {
        return reportWeight;
    }

    public void setReportWeight(double reportWeight) {
        this.reportWeight = reportWeight;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<CClass> getcClasses() {
        return cClasses;
    }

    public void setcClasses(List<CClass> cClasses) {
        this.cClasses = cClasses;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
