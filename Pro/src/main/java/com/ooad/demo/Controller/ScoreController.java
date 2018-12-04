package com.ooad.demo.Controller;

import com.ooad.demo.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 20:00 2018/12/2
 * @Modified by:
 */
@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    @Autowired
    ScoreService scoreService;



    /**
     * @Author: WinstonDeng
     * @Description: 修改展示成绩 presentationScore
     * @Date: 20:05 2018/12/2
     */
    @RequestMapping(value = "/presentation",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setPresentationScoreInScorePage(@RequestParam("roundId") int roundId,
                                                   @RequestParam("seminarId") int seminarId,
                                                   @RequestParam("teamId") int teamId,
                                                   @RequestParam("presentationScore") float presentationScore){
        return scoreService.updatePresentataionScoreByRoundIdAndSeminarIdAndTeamId(roundId, seminarId,
                teamId, presentationScore);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改报告成绩 reportScore
     * @Date: 20:05 2018/12/2
     */
    @RequestMapping(value = "/report",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setReportScoreInScorePage(@RequestParam("roundId") int roundId,
                                                   @RequestParam("seminarId") int seminarId,
                                                   @RequestParam("teamId") int teamId,
                                                   @RequestParam("reportScore") float reportScore){
        return scoreService.updateReportScoreByRoundIdAndSeminarIdAndTeamId(roundId, seminarId,
                teamId, reportScore);
    }
    /**
     * @Author: WinstonDeng
     * @Description: 修改提问成绩 questionScore
     * @Date: 20:05 2018/12/2
     */
    @RequestMapping(value = "/question",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setQuestionScoreInScorePage(@RequestParam("roundId") int roundId,
                                             @RequestParam("seminarId") int seminarId,
                                             @RequestParam("teamId") int teamId,
                                             @RequestParam("questionScore") float questionScore){
        return scoreService.updateQuestionScoreByRoundIdAndSeminarIdAndTeamId(roundId, seminarId,
                teamId, questionScore);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改总成绩 totalScore
     * @Date: 20:05 2018/12/2
     */
    @RequestMapping(value = "/total",method = RequestMethod.PUT)
    @ResponseBody
    public boolean setTotalScoreInScorePage(@RequestParam("roundId") int roundId,
                                               @RequestParam("seminarId") int seminarId,
                                               @RequestParam("teamId") int teamId,
                                               @RequestParam("totalScore") float totalScore){
        return scoreService.updateTotalScoreByRoundIdAndSeminarIdAndTeamId(roundId, seminarId,
                teamId, totalScore);
    }
}
