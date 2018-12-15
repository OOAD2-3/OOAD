package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.User;

/**
 * @Author: WinstonDeng
 * @Description: 登录成功后个人界面
 * @Date: Created in 22:02 2018/12/7
 * @Modified by:
 */
public class UserOverviewVO {
    private String userAccount;
    private String userName;

    public UserOverviewVO(User user){
        userAccount=user.getAccount();
        userName=user.getUsername();
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
}
