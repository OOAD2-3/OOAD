package com.ooad.demo.VO;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 22:44 2018/12/1
 * @Modified by:
 */
public class ReportFileDownloadVO {
    private int seminarId;
    private String courseName;

    private List<String> reportFileUrls=new ArrayList<>();
    private List<String> reportFileNames=new ArrayList<>();

    public ReportFileDownloadVO (Seminar seminar){
        seminarId=seminar.getId();
        for(Presentation presentation:
                seminar.getPresentations()){
                reportFileNames.add(presentation.getPreFileName());
                reportFileUrls.add(presentation.getPreFileUrl());
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

    public List<String> getReportFileUrls() {
        return reportFileUrls;
    }

    public void setReportFileUrls(List<String> reportFileUrls) {
        this.reportFileUrls = reportFileUrls;
    }

    public List<String> getReportFileNames() {
        return reportFileNames;
    }

    public void setReportFileNames(List<String> reportFileNames) {
        this.reportFileNames = reportFileNames;
    }
}
