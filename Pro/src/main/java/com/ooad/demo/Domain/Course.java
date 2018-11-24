package com.ooad.demo.Domain;

import java.sql.Timestamp;
import java.util.List;

public class Course {
    //基本信息
    private int id;
    private int teacherId;              //属于哪个老师
    private String name;
    private String intro;
    private boolean isShareTeam;
    private boolean isShareSeminar;
    private int masterCourseId;

    //课程规则
    private int minTeamMember;
    private int maxTeamMember;
    private Timestamp startTeamTime;
    private Timestamp endTeamTime;
    private int presentationWeight;
    private int questionWeight;
    private int reportWeight;
    private int roundNumber;
}
