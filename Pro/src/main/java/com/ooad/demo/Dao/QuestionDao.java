package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Question;
import com.ooad.demo.Mapper.QuestionMapper;
import com.ooad.demo.Mapper.SeminarMapper;
import com.ooad.demo.Mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 13:04 2018/12/2
 * @Modified by:
 */

@Component
public class QuestionDao {
    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    SeminarMapper seminarMapper;

    @Autowired
    TeamMapper teamMapper;
    /**
     * @Author: WinstonDeng
     * @Description: 新增某一节讨论课某组的提问分数(讨论课进行中打分)
     * @Date: 13:05 2018/12/2
     */
    public boolean addQuestionScoreBySeminarIdAndTeamId(int seminarId,int teamId,float questionScore){
        if(seminarMapper.findById(seminarId)==null){
            System.out.println("新增question错误，提问记录：seminarId:"+seminarId+" 不存在");
            return false;
        }
        if(teamMapper.findById(teamId)==null){
            System.out.println("新增question错误，提问记录：teamId:"+teamId+" 不存在");
            return false;
        }
        try {
            //假设库里存的都是被提问的，所以库字段is_ask应该删掉，
            //判断是否被问只在提问环节进行（若在库中有记录，则已提问过，这个能不能多次提问具体需要看规则）
            questionMapper.insertBySeminarIdAndTeamIdAndQuestionScore(seminarId,teamId,questionScore);

        }catch (Exception e){
            System.out.println("新增question错误："+e.getCause()+" "+e.getMessage());
            return false;
        }
        return true;
    }
}
