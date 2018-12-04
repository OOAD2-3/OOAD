package com.ooad.demo.dao;

import com.ooad.demo.entity.Presentation;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.mapper.PresentationMapper;
import com.ooad.demo.mapper.SeminarMapper;
import com.ooad.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
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
