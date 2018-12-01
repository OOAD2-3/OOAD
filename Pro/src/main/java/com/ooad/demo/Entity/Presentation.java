package com.ooad.demo.Entity;

import java.util.List;

public class Presentation {
    //基础信息
    private int seminarId;      //属于哪次讨论课
    private int teamId;         //属于哪个组
    private int cClassId;        //属于哪个班级
    private int preOrder;       //展示次序
    private float preScore;       //展示得分
    private float reportScore;    //书面报告得分
    private float questionScore;  //提问总得分

    private String preFileName; //展示文件名
    private String preFileUrl;  //展示文件路径

    private String reportFileName;//书面报告文件名
    private String reportFileUrl;//书面报告文件路径

    //关系
    private List<Question> questions;

    public void calculateQuestionScore(){
        questionScore=0;
        for (Question question:
             questions) {
            questionScore += question.getQuestionScore();
        }
        questionScore /= questions.size();
    }

    //==================================================getter AND setter==================================================//
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

    public int getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(int preOrder) {
        this.preOrder = preOrder;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public float getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(float questionScore) {
        this.questionScore = questionScore;
    }
}
