package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Question;
import com.ooad.demo.Entity.Seminar;
import com.ooad.demo.Entity.Team;
import com.ooad.demo.Mapper.PresentationMapper;
import com.ooad.demo.Mapper.SeminarMapper;
import com.ooad.demo.Mapper.TeamMapper;
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
    PresentationMapper presentationMapper;



   @Autowired
    SeminarMapper seminarMapper;

   public List<Presentation> listBySeminarId(int seminarId){
       return presentationMapper.findBySeminarId(seminarId);
   }
/*
   public List<Presentation> listBySeminarId(int seminarId, boolean hasQuestion){
       List<Presentation> presentations=presentationMapper.findBySeminarId(seminarId);

       for(Presentation presentation:
            presentations){

           if(hasQuestion){
               //List<Question> questions=
           }
       }

   }
   */
}