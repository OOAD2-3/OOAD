package com.ooad.demo.pojo.vo;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 14:25 2018/12/12
 * @Modified by:
 */
public class CreateCClassVO {

    /**
     * 课程名
     */
    String name;
    /**
     * 上课时间
     */
    String time;
    /**
     * 上课教室
     */
    String classroom;
    /**
     * 学生名单
     */
    String fileName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
