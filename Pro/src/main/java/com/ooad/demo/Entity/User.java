package com.ooad.demo.Entity;

public class User {
    private int id;
    private String userId;
    private String password;
    private int identity;   //0是学生 1是老师
    private String name;
    private String email;
    private String selfieUrl;
    private boolean active;
    private int msgInterval;//消息发送时间间隔

    //==================================================getter AND setter==================================================//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSelfieUrl() {
        return selfieUrl;
    }

    public void setSelfieUrl(String selfieUrl) {
        this.selfieUrl = selfieUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMsgInterval() {
        return msgInterval;
    }

    public void setMsgInterval(int msgInterval) {
        this.msgInterval = msgInterval;
    }
}
