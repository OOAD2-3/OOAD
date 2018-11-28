package com.ooad.demo.VO;

import com.ooad.demo.Entity.Course;

import java.util.ArrayList;
import java.util.List;

public class SeminarsVO {
    private int courseId;
    private String courseName;

    private List<MyRound> myRounds=new ArrayList<>();
    private List<MyClass> myClasses=new ArrayList<>();

    public SeminarsVO(Course course){
        courseId=course.getId();
        courseName=course.getName();
    }
}

class MyRound{
    private int roundId;
    private int roundOrder;

    private List<MySeminar> mySeminars=new ArrayList<>();

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRoundOrder() {
        return roundOrder;
    }

    public void setRoundOrder(int roundOrder) {
        this.roundOrder = roundOrder;
    }

    public List<MySeminar> getMySeminars() {
        return mySeminars;
    }

    public void setMySeminars(List<MySeminar> mySeminars) {
        this.mySeminars = mySeminars;
    }
}
