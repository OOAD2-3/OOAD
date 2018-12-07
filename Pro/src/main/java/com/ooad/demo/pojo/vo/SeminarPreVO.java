package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.Presentation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: 对应讨论课正在进行的界面
 * @Date: Created in 14:39 2018/11/30
 * @Modified by:
 */
public class SeminarPreVO {


    private int seminarId;
    private String seminarTopic;

    public List<MyPresentation> myPresentations=new ArrayList<>();


    public SeminarPreVO(List<Presentation> presentations){

        seminarId=presentations.get(0).getSeminarId();

        for(Presentation presentation :presentations){
            myPresentations.add(new MyPresentation(presentation));
        }


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

    public List<MyPresentation> getMyPresentations() {
        return myPresentations;
    }

    public void setMyPresentations(List<MyPresentation> myPresentations) {
        this.myPresentations = myPresentations;
    }


}

class MyPresentation{

    private int teamId;
    private String teamNumber;
    private int preOrder;
    private float preScore;
    private String preFileName;
    private String preFileUrl;
    private String reportFileName;
    private String reportFileUrl;

    public MyPresentation(Presentation presentation){
        teamId=presentation.getTeamId();
        teamNumber=presentation.getTeam().getTeamNumber();
        preOrder=presentation.getPreOrder();
        preScore=presentation.getPreScore();
        preFileName=presentation.getPreFileName();
        preFileUrl=presentation.getPreFileUrl();
        reportFileName=presentation.getReportFileName();
        reportFileUrl=presentation.getReportFileUrl();
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(int preOrder) {
        this.preOrder = preOrder;
    }

    public float getPreScore() {
        return preScore;
    }

    public void setPreScore(float preScore) {
        this.preScore = preScore;
    }

    public String getPreFileName() {
        return preFileName;
    }

    public void setPreFileName(String preFileName) {
        this.preFileName = preFileName;
    }

    public String getPreFileUrl() {
        return preFileUrl;
    }

    public void setPreFileUrl(String preFileUrl) {
        this.preFileUrl = preFileUrl;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public String getReportFileUrl() {
        return reportFileUrl;
    }

    public void setReportFileUrl(String reportFileUrl) {
        this.reportFileUrl = reportFileUrl;
    }
}



