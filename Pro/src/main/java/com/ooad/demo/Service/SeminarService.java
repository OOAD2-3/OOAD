package com.ooad.demo.Service;

import com.ooad.demo.Dao.CourseDao;
import com.ooad.demo.Dao.SeminarDao;

import com.ooad.demo.Dao.TeamDao;
import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;


import com.ooad.demo.Entity.Team;


import com.ooad.demo.VO.PreFileDownloadVO;
import com.ooad.demo.VO.ReportFileDownloadVO;
import com.ooad.demo.VO.SeminarInfoVO;
import com.ooad.demo.VO.SeminarSubInfoVO;
import com.ooad.demo.VO.SeminarPreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {
    @Autowired
    SeminarDao seminarDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    TeamDao teamDao;

    /**
     * @Author: WinstonDeng
     * @Description: 给讨论课进行界面使用的VO，该VO包括
     *                  讨论课的id和name，
     *                  讨论课下展示记录的id, team_id, team_num,team_order
     *                  讨论课下的提问id,student_id
     * @Date: 9:18 2018/11/30
     */
    public SeminarPreVO getSeminarPreVOBySeminarId(int seminarId){
        Seminar seminar=seminarDao.getById(seminarId,true);
        SeminarPreVO seminarPreVO=new SeminarPreVO(seminar);
        List<String> teamNumberList=new ArrayList<>();
        //放置队伍编号
        for(int i=0;i<seminarPreVO.getTeamIdList().size();i++){
            teamNumberList.add(teamDao.getById(seminarPreVO.getTeamIdList().get(i),false,false).getName());
        }
        seminarPreVO.setTeamNumberList(teamNumberList);
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
        return new SeminarInfoVO(seminarDao.getById(seminarId, false));

    }

    /**
     * @Author: WinstonDeng
     * @Description: 给讨论课结束后 报告下载界面用的VO
     *            ！！！！暂时没有二进制流的下载！！！
     *                 讨论课id seminar_id
     *                 课程名 course_name
     *                 展示材料 reportFileName, reportFileUrl
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
