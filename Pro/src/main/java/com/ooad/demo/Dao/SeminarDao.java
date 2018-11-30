package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Seminar;
import com.ooad.demo.Entity.Team;
import com.ooad.demo.Mapper.PresentationMapper;
import com.ooad.demo.Mapper.SeminarMapper;
import com.ooad.demo.Mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeminarDao {
    @Autowired
    SeminarMapper seminarMapper;

    @Autowired
    PresentationMapper presentationMapper;

    @Autowired
    TeamMapper teamMapper;

    public Seminar getById(int seminarId,boolean hasPresentation){
        Seminar seminar=seminarMapper.findById(seminarId);

        if(hasPresentation){
            List<Presentation> presentations=presentationMapper.findBySeminarId(seminarId);
            seminar.setPresentations(presentations);

            List<Team> teams=new ArrayList<>();
            for(Presentation presentation:
                presentations){
                teams.add(teamMapper.findById(presentation.getTeamId()));
               // System.out.println(teamMapper.findById(presentation.getTeamId()).getTeamNumber());
            }

            seminar.setTeams(teams);

        }
        return seminar;
    }

    public List<Seminar> listByCourseId(int courseId,boolean hasPresentataion){
        List<Seminar> seminars=new ArrayList<>();
        for(Seminar seminar:
            seminars){
            if(hasPresentataion){
                List<Presentation> presentations=presentationMapper.findBySeminarId(seminar.getId());
                seminar.setPresentations(presentations);
            }
        }
        return seminars;

    }
}
