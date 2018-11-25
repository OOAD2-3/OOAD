package com.ooad.demo.Entity;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public int getPreScore() {
        return preScore;
    }

    public void setPreScore(int preScore) {
        this.preScore = preScore;
    }

    public int getReportScore() {
        return reportScore;
    }

    public void setReportScore(int reportScore) {
        this.reportScore = reportScore;
    }

    public String getPreFileName() {
        return preFileName;
    }

    public void setPreFileName(String preFileName) {
        this.preFileName = preFileName;
    }

    public String getPreFileUrl() {
        return preFileUrl;
    }

    public void setPreFileUrl(String preFileUrl) {
        this.preFileUrl = preFileUrl;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public String getReportFileUrl() {
        return reportFileUrl;
    }

    public void setReportFileUrl(String reportFileUrl) {
        this.reportFileUrl = reportFileUrl;
    }
}
