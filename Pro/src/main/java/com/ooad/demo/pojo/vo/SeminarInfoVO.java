package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.Seminar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class SeminarInfoVO {
    private int seminarId;
    private String seminarTopic;
    private int seminarOrder;
    private String seminarIntro;
    private String seminarState;
    private int roundOrder;
    private String signUpStartTime;
    private String signUpEndTime;

    public SeminarInfoVO(Seminar seminar){
        seminarId=seminar.getId();
        seminarTopic=seminar.getTopic();
        seminarOrder=seminar.getOrderNumber();
        seminarIntro=seminar.getIntro();
        DateFormat df=new SimpleDateFormat("yyyy/MM/dd");

        signUpStartTime=df.format(seminar.getSignUpStartTime());
        signUpEndTime=df.format(seminar.getSignUpEndTime());

        if(seminar.isFinished())
            seminarState="已完成";
        else if(seminar.isStarted())
            seminarState="已开始";
        else
            seminarState="未开始";
    }

    public int getRoundOrder() {
        return roundOrder;
    }

    public void setRoundOrder(int roundOrder) {
        this.roundOrder = roundOrder;
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
}
