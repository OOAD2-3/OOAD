package com.ooad.demo.controller;

import com.ooad.demo.entity.Score;
import com.ooad.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PutMapping(value = "/presentation")
    @ResponseBody
    public boolean setPresentationScoreInScorePage(@RequestBody Score score){
        return scoreService.updatePresentataionScoreByRoundIdAndSeminarIdAndTeamId(score.getRoundId(), score.getSeminarId(),
                score.getTeamId(), score.getPresentationScore());
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改报告成绩 reportScore
     * @Date: 20:05 2018/12/2
     */
    @PutMapping(value = "/report")
    @ResponseBody
    public boolean setReportScoreInScorePage(@RequestBody Score score){
        return scoreService.updateReportScoreByRoundIdAndSeminarIdAndTeamId(score.getRoundId(), score.getSeminarId(),
                score.getTeamId(), score.getReportScore());
    }
    /**
     * @Author: WinstonDeng
     * @Description: 修改提问成绩 questionScore
     * @Date: 20:05 2018/12/2
     */
    @PutMapping(value = "/question")
    @ResponseBody
    public boolean setQuestionScoreInScorePage(@RequestBody Score score){
        return scoreService.updateQuestionScoreByRoundIdAndSeminarIdAndTeamId(score.getRoundId(), score.getSeminarId(),
                score.getTeamId(), score.getQuestionScore());
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改总成绩 totalScore
     * @Date: 20:05 2018/12/2
     */
    @PutMapping(value = "/total")
    @ResponseBody
    public boolean setTotalScoreInScorePage(@RequestBody Score score){
        return scoreService.updateTotalScoreByRoundIdAndSeminarIdAndTeamId(score.getRoundId(), score.getSeminarId(),
                score.getTeamId(), score.getTotalScore());
    }
}
