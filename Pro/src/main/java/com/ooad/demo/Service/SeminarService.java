package com.ooad.demo.Service;

import com.ooad.demo.Dao.SeminarDao;

import com.ooad.demo.Entity.Seminar;

import com.ooad.demo.VO.SeminarInfoVO;
import com.ooad.demo.VO.SeminarPreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeminarService {
    @Autowired
    SeminarDao seminarDao;



    /**
     * @Author: WinstonDeng
     * @Description: 给讨论课进行界面使用的VO，该VO包括
     *                  讨论课的id和name，
     *                  讨论课下展示记录的id, team_id, team_num,team_order
     *                  讨论课下的提问id,student_id
     * @Date: 9:18 2018/11/30
     */
    /*
    public List<SeminarPreVO> listSeminarsVOByCourseId(int courseId){
        List<SeminarPreVO> seminarPreVOS =new ArrayList<>();

        List<Seminar>seminars=seminarDao.listByCourseId(courseId,true);
        for(Seminar seminar:
            seminars){
            //讨论课可见
            if(seminar.isVisible()){
               seminarPreVOS.add(new SeminarPreVO(seminar));
            }
        }

        return seminarPreVOS;
    }
    */
    public SeminarPreVO getSeminarPreVOBySeminarId(int seminarId){
        Seminar seminar=seminarDao.getById(seminarId,true);
        return new SeminarPreVO(seminar);
    }

    /**
     * @Description:开始讨论课按钮的界面，显示讨论课的部分基本信息，具体信息看SeminarInfoVO类
     * @Author:17Wang
     * @Time:20:51 2018/12/1
    */
    public SeminarInfoVO getSeminarInfoVOBySeminarId(int seminarId){
        return new SeminarInfoVO(seminarDao.getById(seminarId, false));
    }

}
