package com.ooad.demo.Entity;

import java.sql.Timestamp;

public class Seminar {
    //基本信息
    private int id;
    private int roundId;           //属于哪个round 默认为0 不属于任何一个
    private String topic;           //讨论课主题
    private String intro;            //讨论课介绍
    private boolean canVisible;   //是否可见
    private boolean isShare;       //是否共享
    private Timestamp startTime;    //讨论课开始时间
    private boolean isFinished;    //是否结束
    private boolean isStarted;     //是否开始

    //规则
    private int teamNumLimit;
    private Timestamp reportDDL;
    private Timestamp signUpStartTime;
    private Timestamp signUpEndTime;
}
