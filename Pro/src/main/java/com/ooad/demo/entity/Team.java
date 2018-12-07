package com.ooad.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
public class Team {
    private int id;
    /**
     * 属于哪个班
     */
    private int cClassId;
    /**
     * 组号，自动生成
     */
    private String teamNumber;
    /**
     * 组名
     */
    private String name;
    /**
     * 组长id
     */
    private int leaderId;
    /**
     * 是否合法
     */
    private boolean valid;
    /**
     * 小组成员
     */
    private List<User> users = new ArrayList<>();
    /**
     * 小组所有的展示
     */
    private List<Presentation> presentations = new ArrayList<>();
    /**
     * 小组所有的提问
     */
    private List<Question> questions = new ArrayList<>();

    /*
    小组所属课程
    不需要
    private Course course;
    */

    /**
     * 小组所属班级
     */
    private CClass cClass;

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

    public CClass getcClass() {
        return cClass;
    }

    public void setcClass(CClass cClass) {
        this.cClass = cClass;
    }
}
