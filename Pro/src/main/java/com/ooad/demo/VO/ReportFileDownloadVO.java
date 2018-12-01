package com.ooad.demo.VO;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: 对应讨论课报告下载界面，暂时没有做二进制流下载
 * @Date: Created in 22:44 2018/12/1
 * @Modified by:
 */
public class ReportFileDownloadVO {
    private int seminarId;
    private String courseName;

    private List<ReportPresentation> reportPresentations=new ArrayList<>();

    //！！！！暂时没有做二进制流下载！！！！！
    public ReportFileDownloadVO (Seminar seminar){
        seminarId=seminar.getId();
        for(Presentation presentation:
                seminar.getPresentations()){
                reportPresentations.add(new ReportPresentation(presentation));
        }
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<ReportPresentation> getReportPresentations() {
        return reportPresentations;
    }

    public void setReportPresentations(List<ReportPresentation> reportPresentations) {
        this.reportPresentations = reportPresentations;
    }
}

class ReportPresentation{
    private int teamId;
    private int preOrder;
    private float reportScore;
    private String reportFileName;
    private String reportFileUrl;
    public ReportPresentation(Presentation presentation){
        teamId=presentation.getTeamId();
        preOrder=presentation.getPreOrder();
        reportScore=presentation.getReportScore();
        reportFileName=presentation.getReportFileName();
        reportFileUrl=presentation.getReportFileUrl();
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(int preOrder) {
        this.preOrder = preOrder;
    }

    public float getReportScore() {
        return reportScore;
    }

    public void setReportScore(float reportScore) {
        this.reportScore = reportScore;
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
