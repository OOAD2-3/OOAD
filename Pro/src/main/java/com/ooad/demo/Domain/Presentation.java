package com.ooad.demo.Domain;

import java.util.List;

public class Presentation {
    //基础信息
    private int id;
    private int seminarId;
    private int preScore;       //展示得分
    private int reportScore;    //书面报告得分

    private String preFileName; //展示文件名
    private String preFileUrl;  //展示文件路径

    private String reportFileName;//书面报告文件名
    private String reportFileUrl;//书面报告文件路径

    //展示提出的问题
    private List<Question> questions;
}
