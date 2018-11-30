package com.ooad.demo.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ooad.demo.Entity.CClass;
import com.ooad.demo.Entity.Course;
import com.ooad.demo.Entity.Round;
import com.ooad.demo.Entity.Seminar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:17Wang
 * @Time:15:26 2018/11/30
*/
public class SeminarsUnderRoundsVO {
    private int courseId;
    private String courseName;

    private List<MyRound> myRounds=new ArrayList<>();
    private List<MyClass> myClasses=new ArrayList<>();

    public SeminarsUnderRoundsVO(Course course){
        courseId=course.getId();
        courseName=course.getName();

        for (CClass cClass
                : course.getcClasses()) {
            myClasses.add(new MyClass(cClass));
        }

        for (Round round:
             course.getRounds()) {
            myRounds.add(new MyRound(round));
        }
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<MyRound> getMyRounds() {
        return myRounds;
    }

    public void setMyRounds(List<MyRound> myRounds) {
        this.myRounds = myRounds;
    }

    public List<MyClass> getMyClasses() {
        return myClasses;
    }

    public void setMyClasses(List<MyClass> myClasses) {
        this.myClasses = myClasses;
    }
}

class MyRound{
    private int roundId;
    private int roundOrder;

    private List<MySeminar> mySeminars=new ArrayList<>();

    public MyRound(Round round){
        roundId=round.getId();
        roundOrder=round.getOrder();

        for (Seminar seminar:
             round.getSeminars()) {
            mySeminars.add(new MySeminar(seminar));
        }
    }

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
