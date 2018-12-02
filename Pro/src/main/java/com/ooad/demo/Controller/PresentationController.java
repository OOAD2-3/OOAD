package com.ooad.demo.Controller;

import com.ooad.demo.Service.PresentationService;
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

    /**
     * @Author: WinstonDeng
     * @Description: 报告打分
     * @Date: 12:59 2018/12/2
     */
    @RequestMapping(value = "/reportscore",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setReportScoreBySeminarIdAndTeamId(@RequestParam int seminarId,@RequestParam int teamId, @RequestParam float reportScore){
        return presentationService.setReportScoreBySeminarIdAndTeamId(seminarId, teamId, reportScore);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 展示打分
     * @Date: 12:59 2018/12/2
     */
    @RequestMapping(value = "/prescore",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setPreScoreBySeminarIdAndTeamId(@RequestParam int seminarId,@RequestParam int teamId, @RequestParam float preScore){
        return presentationService.setPreScoreBySeminarIdAndTeamId(seminarId, teamId, preScore);
    }
}
