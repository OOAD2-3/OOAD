package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.CClass;
import com.ooad.demo.entity.Course;
import com.ooad.demo.entity.Seminar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:17Wang
 * @Time:15:52 2018/11/30
*/
public class SeminarsOverviewVO {
    private int courseId;
    private String courseName;
    private int masterCourseId;

    private List<MyClass> myClasses=new ArrayList<>();
    private List<MySeminar> mySeminars=new ArrayList<>();

    /**
     * @Description:Entity层向DTO层的转换
     * @Author:17Wang
     * @Time:15:24 2018/11/28
     */
    public SeminarsOverviewVO (Course course) {
        courseId = course.getId();
        courseName = course.getName();
        masterCourseId = course.getMasterCourseId();

        for (CClass cClass
                : course.getcClasses()) {
            myClasses.add(new MyClass(cClass));
        }

        for (Seminar seminar
                : course.getSeminars()) {
            //只显示可以显示的讨论课
            if (seminar.isVisible())
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
