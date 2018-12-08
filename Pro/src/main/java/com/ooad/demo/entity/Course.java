package com.ooad.demo.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Course {
    private int id;
    /**
     * 属于哪个老师
     */
    private int teacherId;
    private int masterCourseId;
    private String name;
    private String intro;
    private boolean shareTeam;
    private boolean shareSeminar;

    private int minTeamMember;
    private int maxTeamMember;
    private Timestamp startTeamTime;
    private Timestamp endTeamTime;
    private double presentationWeight;
    private double questionWeight;
    private double reportWeight;
    private int roundNumber;

    /**
     * 课程下的班级
     */
    private List<CClass> cClasses = new ArrayList<>();
    /**
     * 课程下的讨论课
     */
    private List<Seminar> seminars = new ArrayList<>();
    /**
     * 课程下的轮次
     */
    private List<Round> rounds = new ArrayList<>();
    /**
     * 教师信息
     */
    private User teacher;

    /**
     *
     */
    private List<Team> teams=new ArrayList<>();

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

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
