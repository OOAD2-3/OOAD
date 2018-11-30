package com.ooad.demo.Entity;

public class Question {
    //基本信息
    private int id;
    private int presentationId;  //属于哪个pre
    private int studentId;         //属于哪个学生
    private float questionScore;
    private boolean asked;

    //==================================================getter AND setter==================================================//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public float getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(float questionScore) {
        this.questionScore = questionScore;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}
