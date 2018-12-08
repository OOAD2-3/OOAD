package com.ooad.demo.dao;

import com.ooad.demo.entity.*;
import com.ooad.demo.mapper.PresentationMapper;
import com.ooad.demo.mapper.QuestionMapper;
import com.ooad.demo.mapper.SeminarMapper;
import com.ooad.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 22:03 2018/11/29
 * @Modified by:
 */
@Component
public class PresentationDao {
    @Autowired
    private PresentationMapper presentationMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private SeminarMapper seminarMapper;

    @Autowired
    private TeamMapper teamMapper;

    /**
     * Description: 获得讨论课下所有展示记录 可以设置是否含问题
     * Description: 修改
     *
     * @Author: WinstonDeng
     * @Author: 17Wang
     * @Time: 15:08 2018/12/7
     */
    public List<Presentation> listBySeminarId(int seminarId, boolean hasQuestions, boolean hasSeminar, boolean hasTeam) {
        List<Presentation> presentations = presentationMapper.findBySeminarId(seminarId);
        for (Presentation presentation : presentations) {
            if (hasQuestions) {
                List<Question> questions = questionMapper.findBySeminarIdAndTeamId(seminarId, presentation.getTeamId());
                presentation.setQuestions(questions);
            }
            if (hasSeminar) {
                Seminar seminar = seminarMapper.findById(seminarId);
                presentation.setSeminar(seminar);
            }
            if (hasTeam) {
                Team team = teamMapper.findById(presentation.getTeamId());
                presentation.setTeam(team);
            }
        }

        return presentations;
    }

    /**
     * Description:通过teamId获得presentation
     *
     * @Author: 17Wang
     * @Time: 15:26 2018/12/7
     */
    public List<Presentation> listByTeamId(int teamId, boolean hasQuestions, boolean hasSeminar, boolean hasTeam) {
        List<Presentation> presentations = presentationMapper.findByTeamId(teamId);

        for (Presentation presentation : presentations) {
            if (hasQuestions) {
                List<Question> questions = questionMapper.findBySeminarIdAndTeamId(presentation.getSeminarId(), presentation.getTeamId());
                presentation.setQuestions(questions);
            }
            if (hasSeminar) {
                Seminar seminar = seminarMapper.findById(presentation.getSeminarId());
                presentation.setSeminar(seminar);
            }
            if (hasTeam) {
                Team team = teamMapper.findById(presentation.getTeamId());
                presentation.setTeam(team);
            }
        }

        return presentations;
    }

    /**
     * Description:通过cClassId获得presentation
     *
     * @Author: 17Wang
     * @Time: 15:27 2018/12/7
     */
    public List<Presentation> listBycClassId(int cClassId, boolean hasQuestions, boolean hasSeminar, boolean hasTeam) {
        List<Presentation> presentations = presentationMapper.findBycClassId(cClassId);

        for (Presentation presentation : presentations) {
            if (hasQuestions) {
                List<Question> questions = questionMapper.findBySeminarIdAndTeamId(presentation.getSeminarId(), presentation.getTeamId());
                presentation.setQuestions(questions);
            }
            if (hasSeminar) {
                Seminar seminar = seminarMapper.findById(presentation.getSeminarId());
                presentation.setSeminar(seminar);
            }
            if (hasTeam) {
                Team team = teamMapper.findById(presentation.getTeamId());
                presentation.setTeam(team);
            }
        }

        return presentations;
    }

    /**
     * Description:通过preOrder获得presentation
     *
     * @Author: 17Wang
     * @Time: 15:28 2018/12/7
     */
    public Presentation getByPreOrder(int preOrder, boolean hasQuestions, boolean hasSeminar, boolean hasTeam) {
        Presentation presentation = presentationMapper.findByPreOrder(preOrder);

        if (hasQuestions) {
            List<Question> questions = questionMapper.findBySeminarIdAndTeamId(presentation.getSeminarId(), presentation.getTeamId());
            presentation.setQuestions(questions);
        }
        if (hasSeminar) {
            Seminar seminar = seminarMapper.findById(presentation.getSeminarId());
            presentation.setSeminar(seminar);
        }
        if (hasTeam) {
            Team team = teamMapper.findById(presentation.getTeamId());
            presentation.setTeam(team);
        }

        return presentation;
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改某一节讨论课某组的报告分数
     * @Date: 23:54 2018/12/1
     */
    public boolean updatePresentationReportScoreBySeminarIdAndTeamId(int seminarId, int teamId, float reportScore) {

        try {
            Presentation presentation = presentationMapper.findBySeminarIdAndTeamId(seminarId, teamId);
            presentation.setReportScore(reportScore);
            presentationMapper.updateReportScore(presentation);

        } catch (Exception e) {
            System.out.println("更新reportScore错误 " + e.getCause() + " " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * @Author: WinstonDeng
     * @Description: 修改某一节讨论课某组展示分数
     * @Date: 12:52 2018/12/2
     */
    public boolean updatePresentationPreScoreBySemianrIdAndTeamId(int seminarId, int teamId, float preScore) {

        try {
            Presentation presentation = presentationMapper.findBySeminarIdAndTeamId(seminarId, teamId);
            presentation.setPreScore(preScore);
            presentationMapper.updatePreScore(presentation);

        } catch (Exception e) {
            System.out.println("更新preScore错误 " + e.getCause() + " " + e.getMessage());
            return false;
        }
        return true;
    }
}