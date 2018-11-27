package com.ooad.demo.Domian;

import com.ooad.demo.Entity.CClass;
import com.ooad.demo.Entity.Course;
import com.ooad.demo.Entity.Seminar;

import java.util.List;

public class TeacherCourse {
    private Course course;
    private List<CClass> cClasses;
    private List<Seminar> seminars;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<CClass> getcClasses() {
        return cClasses;
    }

    public void setcClasses(List<CClass> cClasses) {
        this.cClasses = cClasses;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
}
