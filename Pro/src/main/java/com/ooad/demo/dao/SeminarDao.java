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

    public Seminar getById(int seminarId,boolean hasPresentation){
        Seminar seminar=seminarMapper.findById(seminarId);

        if(hasPresentation){
            List<Presentation> presentations=presentationMapper.findBySeminarId(seminarId);
            seminar.setPresentations(presentations);

        }
        return seminar;
    }

    public List<Seminar> listByCourseId(int courseId,boolean hasPresentataion){
        List<Seminar> seminars=seminarMapper.findByCourseId(courseId);
        for(Seminar seminar:
            seminars){
            if(hasPresentataion){
                List<Presentation> presentations=presentationMapper.findBySeminarId(seminar.getId());
                seminar.setPresentations(presentations);
            }
        }
        return seminars;
    }

    /**
     * Description: 通过轮次搜索该轮次下的讨论课
     * @Author: 17Wang
     * @Time: 22:55 2018/12/5
    */
    public List<Seminar> listByRoundId(int roundId,boolean hasPresentataion){
        List<Seminar> seminars=seminarMapper.findByRoundId(roundId);
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
