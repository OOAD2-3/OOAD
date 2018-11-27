package com.ooad.demo.DTO;

import com.ooad.demo.Domain.TeacherCourse;
import com.ooad.demo.Entity.CClass;
import com.ooad.demo.Entity.Seminar;

import java.util.List;

public class SeminarOverviewDTO {
    private int courseId;
    private String courseName;
    private int masterCourseId;

    private List<MyClass> myClasses;
    private List<MySeminar> mySeminars;

    /**
     * Domain层向DTO层转换，用于教师端讨论课主页
    */
    public void Initial(TeacherCourse teacherCourse){
        courseId=teacherCourse.getCourse().getId();
        courseName=teacherCourse.getCourse().getName();
        masterCourseId=teacherCourse.getCourse().getMasterCourseId();

        for (CClass cClass:teacherCourse.getcClasses()){
            MyClass newClass=new MyClass();
            newClass.Initial(cClass);
            myClasses.add(newClass);
        }

        for(Seminar seminar: teacherCourse.getSeminars()){
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
