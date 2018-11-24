package com.ooad.demo.Entity;

public class Seminar {
    private int id;
    private int roundId;           //属于哪个round 默认为0 不属于任何一个
    private String topic;           //讨论课主题
    private boolean canVisible;   //是否可见
    private boolean isShare;       //是否共享
}
