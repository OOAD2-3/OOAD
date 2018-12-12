package com.ooad.demo.pojo.vo;

import com.ooad.demo.entity.Course;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.entity.Team;
import com.ooad.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 22:22 2018/12/7
 * @Modified by:
 */
public class TeamsUnderSeminarVO {
    private String teamNumber;
    private String teamName;
    private int leaderId;
    private String leaderName;
    /**
     * 组员(非组长)
     */
    List<MyMember> myMembers=new ArrayList<>();

    public TeamsUnderSeminarVO(Team team){
        teamNumber=team.getTeamNumber();
        teamName=team.getName();
        leaderId=team.getLeaderId();
        for (User user:
                team.getUsers()) {
            if (user.getId() == team.getLeaderId()) {
                leaderName = user.getName();
            } else {
                myMembers.add(new MyMember(user));
            }
        }
    }

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public List<MyMember> getMyMembers() {
        return myMembers;
    }

    public void setMyMembers(List<MyMember> myMembers) {
        this.myMembers = myMembers;
    }
}
class MyMember{
    private String memberAccount;
    private String memberName;
    MyMember(User user){
        memberAccount=user.getAccount();
        memberName=user.getUsername();
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
