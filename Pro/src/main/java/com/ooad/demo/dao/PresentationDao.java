package com.ooad.demo.dao;

import com.ooad.demo.entity.*;
import com.ooad.demo.mapper.*;
import com.ooad.demo.pojo.bo.PresentationTeamBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

   @Autowired
   TeamMapper teamMapper;

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
               List<Question> questions=questionMapper.findBySeminarIdAndTeamId(presentation.getSeminarId(), presentation.getTeamId());
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
   public boolean updatePresentationReportScoreBySeminarIdAndTeamId(int seminarId,int teamId, float reportScore){
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

   /**
    * @Description:连表查询，连的表是类名
    * @Author:17Wang
    * @Time:13:33 2018/12/2
   */
   public List<PresentationTeamBO> listPresentationTeamBOBySeminarIdAndCClassId(int seminarId,int cClassId) {
       List<Presentation> presentations = listBySeminarId(seminarId, true);
       List<PresentationTeamBO> presentationTeamBOS =new ArrayList<>();

       for (Presentation presentation:
            presentations) {
           Team team=teamMapper.findById(presentation.getTeamId());

           //判断这个小组在不在这个班级下
           if(team.getcClassId()==cClassId){
               presentationTeamBOS.add(new PresentationTeamBO(presentation,team));
           }
       }

       return presentationTeamBOS;
   }
}