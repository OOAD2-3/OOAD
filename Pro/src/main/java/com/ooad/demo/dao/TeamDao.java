package com.ooad.demo.dao;

import com.ooad.demo.entity.Presentation;
import com.ooad.demo.entity.Question;
import com.ooad.demo.entity.Team;
import com.ooad.demo.mapper.PresentationMapper;
import com.ooad.demo.mapper.QuestionMapper;
import com.ooad.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 23:52 2018/11/29
 * @Modified by:
 */
@Component
public class TeamDao {
    @Autowired
    PresentationMapper presentationMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    QuestionMapper questionMapper;

    public Team getById(int teamId,boolean hasPresentation,boolean hasQuestion){
        Team team=teamMapper.findById(teamId);
        if(hasPresentation){
            List<Presentation> presentations=presentationMapper.findByTeamId(teamId);
            team.setPresentations(presentations);
        }
        if(hasQuestion){
            List<Question> questions=questionMapper.findByTeamId(teamId);
            team.setQuestions(questions);
        }
        return team;
    }
}
