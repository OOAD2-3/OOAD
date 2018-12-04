package com.ooad.demo.pojo.vo;

import com.ooad.demo.pojo.bo.PresentationTeamBO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class ScoresUnderPresentationVO {
    private int seminarId;      //属于哪次讨论课
    private int cClassId;        //属于哪个班级

    List<MyTeamScore> myScores=new ArrayList<>();

    public ScoresUnderPresentationVO(List<PresentationTeamBO> presentationTeamBOS){
        seminarId=presentationTeamBOS.get(0).getPresentation().getSeminarId();
        cClassId= presentationTeamBOS.get(0).getTeam().getcClassId();

        for (PresentationTeamBO presentationTeamBO:
             presentationTeamBOS) {
            myScores.add(new MyTeamScore(presentationTeamBO));
        }
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public int getcClassId() {
        return cClassId;
    }

    public void setcClassId(int cClassId) {
        this.cClassId = cClassId;
    }

    public List<MyTeamScore> getMyScores() {
        return myScores;
    }

    public void setMyScores(List<MyTeamScore> myScores) {
        this.myScores = myScores;
    }
}

class MyTeamScore{
    private String teamNumber;      //组号
    private float preScore;       //展示得分
    private float reportScore;    //书面报告得分
    private float questionScore;  //提问总得分
    private float totalScore;      //总得分

    public MyTeamScore(PresentationTeamBO presentationTeamBO) {
        teamNumber=presentationTeamBO.getTeam().getTeamNumber();
        preScore=presentationTeamBO.getPresentation().getPreScore();
        reportScore=presentationTeamBO.getPresentation().getReportScore();
        questionScore=presentationTeamBO.getPresentation().getQuestionScore();
        totalScore=presentationTeamBO.getPresentation().getTotalScore();
    }

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public float getPreScore() {
        return preScore;
    }

    public void setPreScore(float preScore) {
        this.preScore = preScore;
    }

    public float getReportScore() {
        return reportScore;
    }

    public void setReportScore(float reportScore) {
        this.reportScore = reportScore;
    }

    public float getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(float questionScore) {
        this.questionScore = questionScore;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }
}
