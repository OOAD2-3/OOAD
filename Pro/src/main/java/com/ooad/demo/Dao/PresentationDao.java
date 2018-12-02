package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Presentation;
import com.ooad.demo.Entity.Question;
import com.ooad.demo.Entity.Seminar;
import com.ooad.demo.Entity.Team;
import com.ooad.demo.Mapper.PresentationMapper;
import com.ooad.demo.Mapper.QuestionMapper;
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
    QuestionMapper questionMapper;

   @Autowired
    SeminarMapper seminarMapper;

   /**
    * @Author: WinstonDeng
    * @Description: 获得讨论课下所有展示记录
    * @Date: 23:53 2018/12/1
    */
   public List<Presentation> listBySeminarId(int seminarId){
       return presentationMapper.findBySeminarId(seminarId);
   }

   /**
    * @Author: WinstonDeng
    * @Description: 获得讨论课下所有展示记录 可以设置是否含问题
    * @Date: 23:53 2018/12/1
    */
   public List<Presentation> listBySeminarId(int seminarId, boolean hasQuestion){
       List<Presentation> presentations=presentationMapper.findBySeminarId(seminarId);

       for(Presentation presentation:
            presentations){

           if(hasQuestion){
               List<Question> questions=questionMapper.findByPresentationId(presentation.getId());
               presentation.setQuestions(questions);
           }
       }
        return presentations;
   }

   /**
    * @Author: WinstonDeng
    * @Description: 修改某一节讨论课的报告分数
    * @Date: 23:54 2018/12/1
    */
   public boolean updatePresentationReportScoreById(int presentationId, float reportScore){
       if(presentationMapper.findById(presentationId)==null){
           System.out.println("更新reportScore错误，讨论课展示记录："+presentationId+" 不存在");
           return false;
       }
       try {
           Presentation presentation=presentationMapper.findById(presentationId);
           presentation.setReportScore(reportScore);
           presentationMapper.updateReportScore(presentation);

       } catch (Exception e){
           System.out.println("更新reportScore错误 "+e.getCause()+" "+e.getMessage());
           return false;
       }
       return true;
   }
}