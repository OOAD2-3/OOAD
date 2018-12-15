package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.User;

/**
 * @Author: WinstonDeng
 * @Description: 个人账户设置界面
 * @Date: Created in 22:17 2018/12/7
 * @Modified by:
 */
public class UserSettingVO {
    private String userAccount;
    private String userName;
    private String email;
    private int msgInterval;

    public UserSettingVO(User user){
        userAccount=user.getAccount();
        userName=user.getUsername();
        email=user.getEmail();
        msgInterval=user.getMsgInterval();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMsgInterval() {
        return msgInterval;
    }

    public void setMsgInterval(int msgInterval) {
        this.msgInterval = msgInterval;
    }
}
