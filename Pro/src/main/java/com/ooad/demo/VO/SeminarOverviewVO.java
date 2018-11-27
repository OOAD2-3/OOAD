package com.ooad.demo.VO;

import com.ooad.demo.Entity.CClass;
import com.ooad.demo.Entity.Course;
import com.ooad.demo.Entity.Seminar;

import java.util.List;

public class SeminarOverviewVO {
    private int courseId;
    private String courseName;
    private int masterCourseId;

    private List<MyClass> myClasses;
    private List<MySeminar> mySeminars;

    /**
     * Domain层向DTO层转换，用于教师端讨论课主页
    */
    public void Initial(Course course){
        courseId=course.getId();
        courseName=course.getName();
        masterCourseId=course.getMasterCourseId();

        for (CClass cClass:course.getcClasses()){
            MyClass newClass=new MyClass();
            newClass.Initial(cClass);
            myClasses.add(newClass);
        }

        for(Seminar seminar: course.getSeminars()){
            MySeminar newSeminar=new MySeminar();
            newSeminar.Initial(seminar);
            mySeminars.add(newSeminar);
        }
    }
}

class MyClass{
    private int classId;
    private String className;

    public void Initial(CClass cClass){
        classId=cClass.getId();
        className=cClass.getName();
    }
}

class MySeminar{
    private int seminarId;
    private String seminarTopic;

    public void Initial(Seminar seminar){
        seminarId=seminar.getId();
        seminarTopic=seminar.getTopic();
    }
}
