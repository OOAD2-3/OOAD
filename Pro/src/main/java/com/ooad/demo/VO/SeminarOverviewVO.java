package com.ooad.demo.VO;

import com.ooad.demo.Entity.CClass;
import com.ooad.demo.Entity.Course;
import com.ooad.demo.Entity.Seminar;

import java.util.ArrayList;
import java.util.List;

public class SeminarOverviewVO {
    private int courseId;
    private String courseName;
    private int masterCourseId;

    private List<MyClass> myClasses=new ArrayList<>();
    private List<MySeminar> mySeminars=new ArrayList<>();

    /**
     * Domain层向DTO层转换，用于教师端讨论课主页
    */
    public SeminarOverviewVO (Course course){
        courseId=course.getId();
        courseName=course.getName();
        masterCourseId=course.getMasterCourseId();

        for (CClass cClass
                :course.getcClasses()){
            myClasses.add(new MyClass(cClass));
        }


        for(Seminar seminar
                :course.getSeminars()){
            mySeminars.add(new MySeminar(seminar));
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

    public int getMasterCourseId() {
        return masterCourseId;
    }

    public void setMasterCourseId(int masterCourseId) {
        this.masterCourseId = masterCourseId;
    }

    public List<MyClass> getMyClasses() {
        return myClasses;
    }

    public void setMyClasses(List<MyClass> myClasses) {
        this.myClasses = myClasses;
    }

    public List<MySeminar> getMySeminars() {
        return mySeminars;
    }

    public void setMySeminars(List<MySeminar> mySeminars) {
        this.mySeminars = mySeminars;
    }
}

class MyClass{
    private int classId;
    private String className;

    public MyClass (CClass cClass){
        classId=cClass.getId();
        className=cClass.getName();
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

class MySeminar{
    private int seminarId;
    private String seminarTopic;

    public MySeminar (Seminar seminar){
        seminarId=seminar.getId();
        seminarTopic=seminar.getTopic();
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
}
