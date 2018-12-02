package com.ooad.demo.VO;

import com.ooad.demo.Entity.CClass;
import com.ooad.demo.Entity.Seminar;

import java.util.ArrayList;
import java.util.List;

public class ScoresUnderPresentationVO {
    private int seminarId;      //属于哪次讨论课
    private int cClassId;        //属于哪个班级

    List<MyScore> myScores=new ArrayList<>();

    public ScoresUnderPresentationVO(Seminar seminar, CClass cClass){
        seminarId=seminar.getId();
        cClassId=cClass.getId();
    }

}

class MyTeam{
    private int teamId;         //属于哪个组
    private String teamNumber;


}

class MyScore{
    private float preScore;       //展示得分
    private float reportScore;    //书面报告得分
    private float questionScore;  //提问总得分

}
