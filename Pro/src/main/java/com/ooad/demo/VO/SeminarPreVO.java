package com.ooad.demo.VO;

import com.ooad.demo.Entity.Course;
import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;
import com.ooad.demo.Entity.Team;

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

    private List<MyPresentation> myPresentations=new ArrayList<>();
    private List<MyTeam> myTeams=new ArrayList<>();

    public SeminarPreVO(Seminar seminar){

        seminarId=seminar.getId();
        seminarTopic=seminar.getTopic();
        for(Presentation presentation:
            seminar.getPresentations()){
            myPresentations.add(new MyPresentation(presentation));
        }
        for (Team team:
            seminar.getTeams()){
            myTeams.add(new MyTeam(team));
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

    public List<MyTeam> getMyTeams() {
        return myTeams;
    }

    public void setMyTeams(List<MyTeam> myTeams) {
        this.myTeams = myTeams;
    }
}

class MyPresentation{

    private int preOrder;
    private float preScore;
    private String preFileName;
    private String preFileUrl;

    public MyPresentation(Presentation presentation){

        preOrder=presentation.getPreOrder();
        preScore=presentation.getPreScore();
        preFileName=presentation.getPreFileName();
        preFileUrl=presentation.getPreFileUrl();
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
}

class MyTeam{
    private int teamId;
    private String teamNumber;

    public MyTeam(Team team){
        teamId=team.getId();
        teamNumber=team.getTeamNumber();
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
}
