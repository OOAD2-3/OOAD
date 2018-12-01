package com.ooad.demo.Entity;

/**
 * @Description:三主键！！！
 * @Author:17Wang
 * @Time:22:14 2018/12/1
*/
public class Score {
    private int seminarId;      //属于哪个讨论课
    private int teamId;        //属于哪个team
    private int roundId;        //属于哪个round

    private float presentationScore;
    private float questionScore;
    private float reportScore;
    private float totalScore;

    /**
     * @Description:计算分数 未完成
     * @Author:17Wang
     * @Time:22:17 2018/12/1
    */
    public float calculate(){
        return 0.1f;
    }
    
    //==================================================getter AND setter==================================================//
    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public float getPresentationScore() {
        return presentationScore;
    }

    public void setPresentationScore(float presentationScore) {
        this.presentationScore = presentationScore;
    }

    public float getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(float questionScore) {
        this.questionScore = questionScore;
    }

    public float getReportScore() {
        return reportScore;
    }

    public void setReportScore(float reportScore) {
        this.reportScore = reportScore;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }
}
