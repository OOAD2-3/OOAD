package com.ooad.demo.Service;

import com.ooad.demo.Dao.PresentationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 0:17 2018/12/2
 * @Modified by:
 */

@Service
public class PresentationService {
    @Autowired
    PresentationDao presentationDao;

    /**
     * @Author: WinstonDeng
     * @Description:  报告材料界面 打分
     *                 讨论课id seminarId
     *                 队伍id  teamId
     *                 报告分数 reportScore
     * @Date: 0:08 2018/12/2
     */

    public boolean setReportScoreBySeminarIdAndTeamId(int seminarId,int teamId,float reportScore){
        return presentationDao.updatePresentationReportScoreBySemianrIdAndTeamId(seminarId,teamId,reportScore);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 展示ppt界面 打分
     *                 讨论课id seminarId
     *                 队伍id teamId
     *                 展示分数 preScore
     * @Date: 12:55 2018/12/2
     */
    public boolean setPreScoreBySeminarIdAndTeamId(int seminarId,int teamId,float preScore){
        return presentationDao.updatePresentationPreScoreBySemianrIdAndTeamId(seminarId, teamId, preScore);
    }
}
