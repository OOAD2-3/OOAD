package com.ooad.demo.dao;

import com.ooad.demo.entity.*;
import com.ooad.demo.mapper.*;
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
    private TeamMapper teamMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PresentationMapper presentationMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CClassMapper cClassMapper;

    /**
     * Description:缺少UserDao
     * @Author: 17Wang
     * @Time: 15:24 2018/12/7
    */
    public Team getById(int teamId,boolean hasUsers,boolean hasPresentations,boolean hasQuestions,boolean hasCClass){
        Team team=teamMapper.findById(teamId);

        if(hasUsers){
            //这里需要连关系表team_student
            //待完成
        }
        if(hasPresentations){
            List<Presentation> presentations=presentationMapper.findByTeamId(teamId);
            team.setPresentations(presentations);
        }
        if(hasQuestions){
            List<Question> questions=questionMapper.findByTeamId(teamId);
            team.setQuestions(questions);
        }
        if(hasCClass){
            CClass cClass=cClassMapper.findById(team.getcClassId());
            team.setcClass(cClass);
        }

        return team;
    }

    /**
     * Description:缺少UserDao
     * @Author: 17Wang
     * @Time: 15:31 2018/12/7
    */
    public List<Team> findBycClassId(int cClassId,boolean hasUsers,boolean hasPresentations,boolean hasQuestions,boolean hasCClass){
        List<Team> teams=teamMapper.findBycClassId(cClassId);

        for(Team team:teams){
            if(hasUsers){
                //这里需要连关系表team_student
                //待完成
            }
            if(hasPresentations){
                List<Presentation> presentations=presentationMapper.findByTeamId(team.getId());
                team.setPresentations(presentations);
            }
            if(hasQuestions){
                List<Question> questions=questionMapper.findByTeamId(team.getId());
                team.setQuestions(questions);
            }
            if(hasCClass){
                CClass cClass=cClassMapper.findById(team.getcClassId());
                team.setcClass(cClass);
            }

        }

        return teams;
    }
}
