package com.ooad.demo.Entity;

public abstract class User {
    protected String userId;
    protected String password;
    protected String name;
    protected String email;
    protected String selfieUrl;
    protected boolean hasActived;
    protected int msgInterval;//消息发送时间间隔

    //==================================================getter AND setter==================================================//
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

    public boolean isHasActived() {
        return hasActived;
    }

    public void setHasActived(boolean hasActived) {
        this.hasActived = hasActived;
    }

    public int getMsgInterval() {
        return msgInterval;
    }

    public void setMsgInterval(int msgInterval) {
        this.msgInterval = msgInterval;
    }
}
