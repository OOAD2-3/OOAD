package com.ooad.demo.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Seminar {

    private int id;
    /**
     * 属于哪个round 默认为0 不属于任何一个
     */
    private int roundId;
    /**
     * 属于哪个course
     */
    private int courseId;
    /**
     * 属于该course下哪一轮
     */
    private int orderNumber;
    /**
     * 讨论课主题
     */
    private String topic;
    /**
     * 讨论课介绍
     */
    private String intro;
    /**
     * 是否可见
     */
    private boolean visible;
    /**
     * 是否共享
     */
    private boolean share;
    /**
     * 讨论课开始时间
     */
    private Timestamp startTime;
    /**
     * 是否结束
     */
    private boolean finished;
    /**
     * 是否开始
     */
    private boolean started;

    private int teamNumLimit;
    private Timestamp reportDDL;
    private Timestamp signUpStartTime;
    private Timestamp signUpEndTime;

    /**
     * 讨论课下的所有展示
     */
    private List<Presentation> presentations;
    /**
     * 讨论课所属的所有班级
     */
    private List<CClass> cClasses;
    /**
     * 讨论课所属的课程
     */
    private Course course;
    /**
     * 讨论课所属的轮次
     */
    private Round round;

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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
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

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<CClass> getcClasses() {
        return cClasses;
    }

    public void setcClasses(List<CClass> cClasses) {
        this.cClasses = cClasses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
