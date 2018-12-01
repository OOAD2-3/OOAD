package com.ooad.demo.VO;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description:对应Seminar Entity的字段
 * @Author:17Wang
 * @Time:21:17 2018/12/1
*/
public class SeminarInfoVO {
    //基本信息
    private int id;
    private int roundId;           //属于哪个round 默认为0 不属于任何一个
    private int courseId;          //属于哪个course

    private String topic;           //讨论课主题
    private String intro;            //讨论课介绍
    private boolean visible;   //是否可见
    private boolean share;       //是否共享
    private String startTime;    //讨论课开始时间
    private boolean finished;    //是否结束
    private boolean started;     //是否开始

    //规则
    private int teamNumLimit;
    private String reportDDL;
    private String signUpStartTime;
    private String signUpEndTime;

    //关系
    private List<Presentation> presentations;

    public SeminarInfoVO(Seminar seminar) {
        id = seminar.getId();
        roundId = seminar.getRoundId();
        courseId = seminar.getCourseId();

        topic = seminar.getTopic();
        intro = seminar.getIntro();
        visible = seminar.isVisible();
        share = seminar.isShare();

        finished = seminar.isFinished();
        started = seminar.isStarted();
        teamNumLimit = seminar.getTeamNumLimit();

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        if (seminar.getStartTime() != null)
            startTime = df.format(seminar.getStartTime());
        if (seminar.getReportDDL() != null)
            reportDDL = df.format(seminar.getReportDDL());
        if (seminar.getSignUpStartTime() != null)
            signUpStartTime = df.format(seminar.getSignUpStartTime());
        if (seminar.getSignUpEndTime() != null)
            signUpEndTime = df.format(seminar.getSignUpEndTime());

        presentations = seminar.getPresentations();
    }
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getTeamNumLimit() {
        return teamNumLimit;
    }

    public void setTeamNumLimit(int teamNumLimit) {
        this.teamNumLimit = teamNumLimit;
    }

    public String getReportDDL() {
        return reportDDL;
    }

    public void setReportDDL(String reportDDL) {
        this.reportDDL = reportDDL;
    }

    public String getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(String signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public String getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(String signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }
}
