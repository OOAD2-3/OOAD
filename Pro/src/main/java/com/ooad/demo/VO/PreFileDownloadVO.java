package com.ooad.demo.VO;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: 对应讨论课ppt下载界面，暂时没有做二进制流下载
 * @Date: Created in 19:47 2018/11/30
 * @Modified by:
 */
public class PreFileDownloadVO {
    private int seminarId;
    private String courseName;

   private List<String> preFileUrls=new ArrayList<>();
   private List<String> preFileNames=new ArrayList<>();

   //！！！！暂时没有做二进制流下载！！！！！
   public PreFileDownloadVO(Seminar seminar){
       seminarId=seminar.getId();
       for(Presentation presentation:
               seminar.getPresentations()){
           preFileNames.add(presentation.getPreFileName());
           preFileUrls.add(presentation.getPreFileUrl());
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

    public List<String> getPreFileUrls() {
        return preFileUrls;
    }

    public void setPreFileUrls(List<String> preFileUrls) {
        this.preFileUrls = preFileUrls;
    }

    public List<String> getPreFileNames() {
        return preFileNames;
    }

    public void setPreFileNames(List<String> preFileNames) {
        this.preFileNames = preFileNames;
    }
}
