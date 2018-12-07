package com.ooad.demo.entity;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Question {
    /**
     * 属于哪个讨论课
     */
    private int seminarId;
    /**
     * 属于哪个队伍
     */
    private int teamId;
    /**
     * 提问分数
     */
    private float questionScore;
    /**
     * 是否被提问，可能不需要
     */
    private boolean asked;
    /**
     * 小组信息
     */
    private Team team;
    /**
     * 展示信息
     */
    private Presentation presentation;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
