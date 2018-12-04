package com.ooad.demo.controller;

import com.ooad.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 13:45 2018/12/2
 * @Modified by:
 */
@RestController
@RequestMapping(value = "questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    /**
     * @Author: WinstonDeng
     * @Description:  新增某一节讨论课某组的提问分数(讨论课进行中打分)
     * @Date: 13:46 2018/12/2
     */
    @RequestMapping(value = "/questionscore",method = RequestMethod.POST)
    @ResponseBody
    public boolean setQuestionScoreBySeminarIdAndTeamId(@RequestParam("seminarId") int seminarId,@RequestParam("teamId") int teamId,@RequestParam("questionScore") float questionScore){
        return questionService.addQuestionScoreBySeminarIdAndTeamId(seminarId, teamId, questionScore);
    }
}