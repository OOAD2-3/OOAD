package com.ooad.demo.service;

import com.ooad.demo.dao.ScoreDao;
import com.ooad.demo.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 19:51 2018/12/2
 * @Modified by:
 */
@Service
public class ScoreService {
    @Autowired
    ScoreDao scoreDao;

    /**
     * @Author: WinstonDeng
     * @Description: 通过roundId, seminarId, teamId
     *                 查找Score
     * @Date: 19:52 2018/12/2
     */
    public Score getScoreByRoundIdAndSeminarIdAndTeamId(int roundId,int seminarId,int teamId){
        return scoreDao.getByRoundIdAndSeminarIdAndTeamId(roundId, seminarId, teamId);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改展示成绩 presentationScore
     * @Date: 19:54 2018/12/2
     */
    public boolean updatePresentataionScoreByRoundIdAndSeminarIdAndTeamId(int roundId,int seminarId,int teamId,float presentationScore){
        return scoreDao.updatePresentationScore(roundId, seminarId, teamId, presentationScore);
    }
    /**
     * @Author: WinstonDeng
     * @Description: 修改报告成绩 reportScore
     * @Date: 19:54 2018/12/2
     */
    public boolean updateReportScoreByRoundIdAndSeminarIdAndTeamId(int roundId,int seminarId,int teamId,float reportScore){
        return scoreDao.updateReportScore(roundId, seminarId, teamId, reportScore);
    }
    /**
     * @Author: WinstonDeng
     * @Description: 修改提问成绩 questionScore
     * @Date: 19:54 2018/12/2
     */
    public boolean updateQuestionScoreByRoundIdAndSeminarIdAndTeamId(int roundId,int seminarId,int teamId,float questionScore){
        return scoreDao.updateQuestionScore(roundId, seminarId, teamId, questionScore);
    }
    /**
     * @Author: WinstonDeng
     * @Description: 修改总成绩 totalScore
     * @Date: 19:54 2018/12/2
     */
    public boolean updateTotalScoreByRoundIdAndSeminarIdAndTeamId(int roundId,int seminarId,int teamId,float totalScore){
        return scoreDao.updateTotalScore(roundId, seminarId, teamId, totalScore);
    }
}
