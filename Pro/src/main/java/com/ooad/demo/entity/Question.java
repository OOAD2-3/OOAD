package com.ooad.demo.entity;

public class Question {
    //基本信息

    private int seminarId;  //属于哪个讨论课
    private int teamId;     //属于哪个队伍

    //private int studentId;         //属于哪个学生

    private float questionScore;
    private boolean asked;

    //==================================================getter AND setter==================================================//


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



    public float getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(float questionScore) {
        this.questionScore = questionScore;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}
