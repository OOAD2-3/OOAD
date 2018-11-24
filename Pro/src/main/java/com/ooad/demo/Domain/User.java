package com.ooad.demo.Domain;

public abstract class User {
    protected String userId;
    protected String password;
    protected String name;
    protected String email;
    protected String selfieUrl;
    protected boolean isActived;
    protected int msgInterval;//消息发送时间间隔

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

    public boolean isActived() {
        return isActived;
    }

    public void setActived(boolean actived) {
        isActived = actived;
    }

    public int getMsgInterval() {
        return msgInterval;
    }

    public void setMsgInterval(int msgInterval) {
        this.msgInterval = msgInterval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (isActived != user.isActived) return false;
        if (msgInterval != user.msgInterval) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return selfieUrl != null ? selfieUrl.equals(user.selfieUrl) : user.selfieUrl == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (selfieUrl != null ? selfieUrl.hashCode() : 0);
        result = 31 * result + (isActived ? 1 : 0);
        result = 31 * result + msgInterval;
        return result;
    }
}
