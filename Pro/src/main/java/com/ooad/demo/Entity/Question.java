package com.ooad.demo.Entity;

public class Question {
    //基本信息
    private int id;
    private int presentationId;
    private int teamId;
    private int questionScore;
    private boolean isAsked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public boolean isAsked() {
        return isAsked;
    }

    public void setAsked(boolean asked) {
        isAsked = asked;
    }
}
