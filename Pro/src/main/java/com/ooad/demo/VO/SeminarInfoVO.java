package com.ooad.demo.VO;

import com.ooad.demo.Entity.Seminar;

import java.sql.Timestamp;

public class SeminarInfoVO {
    private int seminarId;
    private String seminarTopic;
    private int seminarOrder;
    private String seminarIntro;
    private String seminarState;
    private Timestamp signUpStartTime;
    private Timestamp signUpEndTime;

    public SeminarInfoVO(Seminar seminar){
        seminarId=seminar.getId();
        seminarTopic=seminar.getTopic();
        seminarOrder=seminar.getOrderNumber();
        seminarIntro=seminar.getIntro();
        signUpStartTime=seminar.getSignUpStartTime();
        signUpEndTime=seminar.getSignUpEndTime();
        if(seminar.isFinished())
            seminarState="已完成";
        else if(seminar.isStarted())
            seminarState="已开始";
        else
            seminarState="未开始";
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public String getSeminarTopic() {
        return seminarTopic;
    }

    public void setSeminarTopic(String seminarTopic) {
        this.seminarTopic = seminarTopic;
    }

    public int getSeminarOrder() {
        return seminarOrder;
    }

    public void setSeminarOrder(int seminarOrder) {
        this.seminarOrder = seminarOrder;
    }

    public String getSeminarIntro() {
        return seminarIntro;
    }

    public void setSeminarIntro(String seminarIntro) {
        this.seminarIntro = seminarIntro;
    }

    public String getSeminarState() {
        return seminarState;
    }

    public void setSeminarState(String seminarState) {
        this.seminarState = seminarState;
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
