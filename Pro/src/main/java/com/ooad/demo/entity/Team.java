package com.ooad.demo.entity;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Team {
    //基本信息
    private int id;
    private int cClassId;      //属于哪个班
    private String teamNumber; //组号，自动生成
    private String name;
    private int leaderId;      //组长id
    private boolean valid;   //该小组是否合法

    //关系
    private List<User> users;       //学生
    private List<Presentation> presentations;
    private List<Question> questions;

    //==================================================getter AND setter==================================================//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcClassId() {
        return cClassId;
    }

    public void setcClassId(int cClassId) {
        this.cClassId = cClassId;
    }

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
