package com.ooad.demo.service;

import com.ooad.demo.dao.*;

import com.ooad.demo.entity.Seminar;


import com.ooad.demo.pojo.bo.PresentationTeamBO;
import com.ooad.demo.pojo.vo.PreFileDownloadVO;
import com.ooad.demo.pojo.vo.ReportFileDownloadVO;
import com.ooad.demo.pojo.vo.SeminarInfoVO;
import com.ooad.demo.pojo.vo.SeminarSubInfoVO;
import com.ooad.demo.pojo.vo.SeminarPreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Service
public class SeminarService {
    @Autowired
    SeminarDao seminarDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    TeamDao teamDao;

    @Autowired
    PresentationDao presentationDao;

    @Autowired
    RoundDao roundDao;

    /**
     * @Author: WinstonDeng
     * @Description: 给讨论课进行界面使用的VO，该VO包括
     *                  讨论课的id和name，
     *                  讨论课下展示记录的id, team_id, team_num,team_order
     *                  讨论课下的提问id,student_id
     * @Date: 9:18 2018/11/30
     */
    public SeminarPreVO getSeminarPreVOBySeminarIdAndCClassId(int seminarId,int cClassId){
        Seminar seminar=seminarDao.getById(seminarId,true);
        List<PresentationTeamBO> presentationTeamBOS=presentationDao.listPresentationTeamBOBySeminarIdAndCClassId(seminarId,cClassId);
        SeminarPreVO seminarPreVO=new SeminarPreVO(presentationTeamBOS);
       //设置讨论课主题
        seminarPreVO.setSeminarTopic(seminar.getTopic());

        return seminarPreVO;
    }

    /**
     * @Author: WinstonDeng
     * @Description: 给讨论课展示ppt下载界面用的VO
     *                  ！！！！暂时没有二进制流的下载！！！
     *                  讨论课id seminar_id
     *                  课程名 course_name
     *                  展示材料 preFileName, preFileUrl
     * @Date: 22:52 2018/12/1
     */
    public PreFileDownloadVO getPreFileDownLoadVOBySeminarId(int seminarId) {
        Seminar seminar = seminarDao.getById(seminarId, true);
        PreFileDownloadVO preFileDownloadVO = new PreFileDownloadVO(seminar);
        //只拿course名字
        preFileDownloadVO.setCourseName(courseDao.getById(seminar.getCourseId(), false, false, false).getName());
        return preFileDownloadVO;
    }
    /**
     * @Description:开始讨论课按钮的界面，显示讨论课的部分基本信息，具体信息看SeminarInfoVO类
     * @Author:17Wang
     * @Time:20:51 2018/12/1
    */
    public SeminarSubInfoVO getSeminarSubInfoVOBySeminarId(int seminarId){
        return new SeminarSubInfoVO(seminarDao.getById(seminarId, false));
    }

    /**
     * @Description:将SeminarEntity转换成SeminarInfoVO，主要是时间格式上的改变
     * @Author:17Wang
     * @Time:21:45 2018/12/1
    */
    public SeminarInfoVO getSeminarInfoVOBySeminarId(int seminarId){
        SeminarInfoVO seminarInfoVO=new SeminarInfoVO(seminarDao.getById(seminarId, false));
        int roundOrder=roundDao.getById(seminarDao.getById(seminarId,false).getRoundId(),false).getOrder();
        seminarInfoVO.setRoundOrder(roundOrder);
        return seminarInfoVO;

    }

    /**
     * @Author: WinstonDeng
     * @Description: 给讨论课结束后 报告下载界面用的VO
     *            ！！！！暂时没有二进制流的下载！！！
     *                 讨论课id seminar_id
     *                 课程名 course_name
     *                 报告材料 reportFileName, reportFileUrl
     * @Date: 22:54 2018/12/1
     */
    public ReportFileDownloadVO getReportFileDownliadVOBySeminarId(int seminarId){
        Seminar seminar=seminarDao.getById(seminarId,true);
        ReportFileDownloadVO reportFileDownloadVO=new ReportFileDownloadVO(seminar);
        //只拿course名字
        reportFileDownloadVO.setCourseName(courseDao.getById(seminar.getCourseId(),false,false,false).getName());
        return reportFileDownloadVO;
    }


}
