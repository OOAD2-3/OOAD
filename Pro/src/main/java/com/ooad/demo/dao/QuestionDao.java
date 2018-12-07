package com.ooad.demo.dao;

import com.ooad.demo.entity.Question;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.entity.Team;
import com.ooad.demo.mapper.QuestionMapper;
import com.ooad.demo.mapper.SeminarMapper;
import com.ooad.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 13:04 2018/12/2
 * @Modified by:
 */
@Component
public class QuestionDao {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private SeminarMapper seminarMapper;

    /**
     * Description:通过seminarId和teamId查找所有的提问信息
     *
     * @Author: 17Wang
     * @Time: 14:57 2018/12/7
     */
    public List<Question> listBySeminarIdAndTeamId(int seminarId, int teamId, boolean hasSeminar, boolean hasTeam) {
        List<Question> questions = questionMapper.findBySeminarIdAndTeamId(seminarId, teamId);

        for (Question question : questions) {
            if (hasSeminar) {
                Seminar seminar = seminarMapper.findById(seminarId);
                question.setSeminar(seminar);
            }
            if (hasTeam) {
                Team team = teamMapper.findById(teamId);
                question.setTeam(team);
            }
        }

        return questions;
    }

    /**
     * Description:通过teamId查找小组的所有的提问信息
     *
     * @Author: 17Wang
     * @Time: 15:04 2018/12/7
     */
    public List<Question> listByTeamId(int teamId, boolean hasSeminar, boolean hasTeam) {
        List<Question> questions = questionMapper.findByTeamId(teamId);

        for (Question question : questions) {
            if (hasSeminar) {
                Seminar seminar = seminarMapper.findById(question.getSeminarId());
                question.setSeminar(seminar);
            }
            if (hasTeam) {
                Team team = teamMapper.findById(teamId);
                question.setTeam(team);
            }
        }

        return questions;
    }

    /**
     * Description:修改questionScore成绩
     *
     * @Author: WinstonDeng
     * @Author:17Wang
     * @Time: 14:54 2018/12/7
     */
    public boolean addQuestionScoreBySeminarIdAndTeamId(int seminarId, int teamId, float questionScore) {
        try {
            //假设库里存的都是被提问的，所以库字段is_ask应该删掉，
            //判断是否被问只在提问环节进行（若在库中有记录，则已提问过，这个能不能多次提问具体需要看规则）
            questionMapper.insertBySeminarIdAndTeamIdAndQuestionScore(seminarId, teamId, questionScore);
        } catch (Exception e) {
            System.out.println("新增question错误：" + e.getCause() + " " + e.getMessage());
            return false;
        }

        return true;
    }
}
