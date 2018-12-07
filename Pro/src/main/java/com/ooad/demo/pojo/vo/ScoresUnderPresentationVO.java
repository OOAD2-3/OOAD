package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.Presentation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class ScoresUnderPresentationVO {
    /**
     * 属于哪次讨论课
     */
    private int seminarId;
    /**
     * 属于哪个班级
     */
    private int cClassId;

    List<MyTeamScore> myScores=new ArrayList<>();

    public ScoresUnderPresentationVO(List<Presentation> presentations){
        seminarId=presentations.get(0).getSeminarId();
        cClassId= presentations.get(0).getTeam().getcClassId();

        for (Presentation presentation:
             presentations) {
            myScores.add(new MyTeamScore(presentation));
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
    /**
     * 组号
     */
    private String teamNumber;
    /**
     * 展示得分
     */
    private float preScore;
    /**
     * 书面报告得分
     */
    private float reportScore;
    /**
     * 提问总得分
     */
    private float questionScore;
    /**
     * 总得分
     */
    private float totalScore;

    public MyTeamScore(Presentation presentation) {
        teamNumber=presentation.getTeam().getTeamNumber();
        preScore=presentation.getPreScore();
        reportScore=presentation.getReportScore();
        questionScore=presentation.getQuestionScore();
        totalScore=presentation.getTotalScore();
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
