package com.ooad.demo.Entity;

public class Team {
    //基本信息
    private int id;
    private int cClassId;      //属于哪个班
    private String teamNumber; //组号，自动生成
    private String name;
    private int leaderId;      //组长id
    private boolean isValid;   //该小组是否合法
}
