package com.ooad.demo.controller;

import com.ooad.demo.dao.PresentationDao;
import com.ooad.demo.entity.Presentation;
import com.ooad.demo.pojo.vo.ScoresUnderPresentationVO;
import com.ooad.demo.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping(value = "/scores/report")
    @ResponseBody
    public boolean setReportScoreBySeminarIdAndTeamId(@RequestBody Presentation presentation){
        return presentationDao.updatePresentationReportScoreBySeminarIdAndTeamId(presentation.getSeminarId(), presentation.getTeamId(), presentation.getReportScore());
    }

    /**
     * @Author: WinstonDeng
     * @Description: 展示打分
     * @Date: 12:59 2018/12/2
     */
    @PutMapping(value = "/scores/pre")
    @ResponseBody
    public boolean setPreScoreBySeminarIdAndTeamId(@RequestBody Presentation presentation){
        return presentationDao.updatePresentationPreScoreBySemianrIdAndTeamId(presentation.getSeminarId(), presentation.getTeamId(), presentation.getPreScore());
    }
    
    /**
     * @Description:显示一个seminar和class下所有队伍的所有分数（三个分数+总分）
     * @Author:17Wang
     * @Time:14:26 2018/12/2
    */
    @GetMapping(value = "/scores")
    @ResponseBody
    public ScoresUnderPresentationVO scoresUnderPresentationVOS(@RequestParam int seminarId,@RequestParam int classId){
        return presentationService.listScoresUnderPresentationVOBySeminarIdAndCClassId(seminarId, classId);
    }
}
