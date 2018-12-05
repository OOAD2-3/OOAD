package com.ooad.demo.dao;

import com.ooad.demo.entity.Score;
import com.ooad.demo.mapper.RoundMapper;
import com.ooad.demo.mapper.ScoreMapper;
import com.ooad.demo.mapper.SeminarMapper;
import com.ooad.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 16:27 2018/12/2
 * @Modified by:
 */
@Component
public class ScoreDao {
    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    SeminarMapper seminarMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    RoundMapper roundMapper;

    /**
     * @Author: WinstonDeng
     * @Description: 通过roundId, seminarId, teamId
     *                 查找Score
     * @Date: 16:28 2018/12/2
     */
    public Score getByRoundIdAndSeminarIdAndTeamId(int roundId,int seminarId,int teamId){
        return scoreMapper.findByRoundIdAndSeminarIdAndTeamId(roundId,seminarId,teamId);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 通过roundId, seminarId, teamId
     *                 修改展示总分 presentationScore
     * @Date: 16:32 2018/12/2
     */
    public boolean updatePresentationScore(int roundId,int seminarId,int teamId, float presentationScore){
        try {
            Score score=scoreMapper.findByRoundIdAndSeminarIdAndTeamId(roundId,seminarId,teamId);
            score.setPresentationScore(presentationScore);
            score.setTotalScore(score.calculate());
            scoreMapper.updatePreScore(score);
            scoreMapper.updateTotalScore(score);
        }catch (Exception e){
            System.out.println("更新Score的presentationScore错误："+e.getCause()+" "+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * @Author: WinstonDeng
     * @Description: 通过roundId, seminarId, teamId
     *                 修改报告总分 reportScore
     * @Date: 16:39 2018/12/2
     */
    public boolean updateReportScore(int roundId,int seminarId,int teamId, float reportScore){

        try {
            Score score=scoreMapper.findByRoundIdAndSeminarIdAndTeamId(roundId,seminarId,teamId);
            score.setReportScore(reportScore);
            score.setTotalScore(score.calculate()); //总分也改变
            scoreMapper.updateReportScore(score);
            scoreMapper.updateTotalScore(score);
        }catch (Exception e){
            System.out.println("更新Score的reportScore错误："+e.getCause()+" "+e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * @Author: WinstonDeng
     * @Description: 通过roundId, seminarId, teamId
     *                 修改提问总分 questionScore
     * @Date: 16:41 2018/12/2
     */
    public boolean updateQuestionScore(int roundId,int seminarId,int teamId, float questionScore){

        try {
            Score score=scoreMapper.findByRoundIdAndSeminarIdAndTeamId(roundId,seminarId,teamId);
            score.setQuestionScore(questionScore);
            score.setTotalScore(score.calculate());
            scoreMapper.updateQuestionScore(score);
            scoreMapper.updateTotalScore(score);
        }catch (Exception e){
            System.out.println("更新Score的QuestionScore错误："+e.getCause()+" "+e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * @Author: WinstonDeng
     * @Description: 通过roundId, seminarId, teamId
     *                 修改总成绩 totalScore
     * @Date: 16:43 2018/12/2
     */
    public boolean updateTotalScore(int roundId,int seminarId,int teamId, float totalScore){

        try {
            Score score=scoreMapper.findByRoundIdAndSeminarIdAndTeamId(roundId,seminarId,teamId);
            score.setTotalScore(totalScore);
            scoreMapper.updateTotalScore(score);
        }catch (Exception e){
            System.out.println("更新Score的totalScore错误："+e.getCause()+" "+e.getMessage());
            return false;
        }
        return true;
    }
}
