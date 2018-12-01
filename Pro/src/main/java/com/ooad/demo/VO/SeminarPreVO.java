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
    private List<Integer> teamIdList=new ArrayList<>();
    private List<String> teamNumberList=new ArrayList<>();


    public SeminarPreVO(Seminar seminar){

        seminarId=seminar.getId();
        seminarTopic=seminar.getTopic();
        for(Presentation presentation:
            seminar.getPresentations()){
            myPresentations.add(new MyPresentation(presentation));
            teamIdList.add(presentation.getTeamId());
        }
//        for (Team team:
//            seminar.getTeams()){
//            myTeams.add(new MyTeam(team));
//        }

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

    public List<Integer> getTeamIdList() {
        return teamIdList;
    }

    public void setTeamIdList(List<Integer> teamIdList) {
        this.teamIdList = teamIdList;
    }

    public List<String> getTeamNumberList() {
        return teamNumberList;
    }

    public void setTeamNumberList(List<String> teamNumberList) {
        this.teamNumberList = teamNumberList;
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


