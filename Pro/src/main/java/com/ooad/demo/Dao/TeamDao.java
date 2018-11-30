package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Question;
import com.ooad.demo.Entity.Team;
import com.ooad.demo.Mapper.PresentationMapper;
import com.ooad.demo.Mapper.QuestionMapper;
import com.ooad.demo.Mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 23:52 2018/11/29
 * @Modified by:
 */
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
//        if(hasQuestion){
//            List<Question> questions=questionMapper.findByTeamId(teamId);
//            team.setQuestions(questions);
//        }
        return team;
    }
}
