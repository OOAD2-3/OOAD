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
               List<Question> questions=questionMapper.findBySeminarIdAndTeamId(presentation.getSeminarId(),presentation.getTeamId());
               presentation.setQuestions(questions);
           }
       }
        return presentations;
   }

   /**
    * @Author: WinstonDeng
    * @Description: 修改某一节讨论课某组的报告分数
    * @Date: 23:54 2018/12/1
    */
   public boolean updatePresentationReportScoreBySemianrIdAndTeamId(int seminarId,int teamId, float reportScore){
       if(presentationMapper.findBySeminarIdAndTeamId(seminarId,teamId)==null){
           System.out.println("更新reportScore错误，讨论课展示记录：seminarId:"+seminarId+" teamId:"+teamId+" 不存在");
           return false;
       }
       try {
           Presentation presentation=presentationMapper.findBySeminarIdAndTeamId(seminarId,teamId);
           presentation.setReportScore(reportScore);
           presentationMapper.updateReportScore(presentation);

       } catch (Exception e){
           System.out.println("更新reportScore错误 "+e.getCause()+" "+e.getMessage());
           return false;
       }
       return true;
   }

   /**
    * @Author: WinstonDeng
    * @Description: 修改某一节讨论课某组展示分数
    * @Date: 12:52 2018/12/2
    */
   public boolean updatePresentationPreScoreBySemianrIdAndTeamId(int seminarId,int teamId, float preScore){
       if(presentationMapper.findBySeminarIdAndTeamId(seminarId,teamId)==null){
           System.out.println("更新preScore错误，讨论课展示记录：seminarId:"+seminarId+" teamId:"+teamId+" 不存在");
           return false;
       }
       try {
           Presentation presentation=presentationMapper.findBySeminarIdAndTeamId(seminarId,teamId);
           presentation.setPreScore(preScore);
           presentationMapper.updatePreScore(presentation);

       } catch (Exception e){
           System.out.println("更新preScore错误 "+e.getCause()+" "+e.getMessage());
           return false;
       }
       return true;
   }
}