package com.ooad.demo.Controller;

import com.ooad.demo.Dao.PresentationDao;
import com.ooad.demo.POJO.VO.ScoresUnderPresentationVO;
import com.ooad.demo.Service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 0:20 2018/12/2
 * @Modified by:
 */
@RestController
@RequestMapping(value = "/presentations")
public class PresentationController {
    @Autowired
    PresentationService presentationService;

    @Autowired
    PresentationDao presentationDao;

    /**
     * @Author: WinstonDeng
     * @Description: 报告打分
     * @Date: 12:59 2018/12/2
     */
    @RequestMapping(value = "/scores/report",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setReportScoreBySeminarIdAndTeamId(@RequestParam int seminarId,@RequestParam int teamId, @RequestParam float reportScore){
        return presentationDao.updatePresentationReportScoreBySeminarIdAndTeamId(seminarId, teamId, reportScore);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 展示打分
     * @Date: 12:59 2018/12/2
     */
    @RequestMapping(value = "/scores/pre",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setPreScoreBySeminarIdAndTeamId(@RequestParam int seminarId,@RequestParam int teamId, @RequestParam float preScore){
        return presentationDao.updatePresentationPreScoreBySemianrIdAndTeamId(seminarId, teamId, preScore);
    }
    
    /**
     * @Description:显示一个seminar和class下所有队伍的所有分数（三个分数+总分）
     * @Author:17Wang
     * @Time:14:26 2018/12/2
    */
    @RequestMapping(value = "/scores",method = RequestMethod.GET)
    @ResponseBody
    public ScoresUnderPresentationVO scoresUnderPresentationVOS(@RequestParam int seminarId,@RequestParam int classId){
        return presentationService.listScoresUnderPresentationVOBySeminarIdAndCClassId(seminarId, classId);
    }
}
