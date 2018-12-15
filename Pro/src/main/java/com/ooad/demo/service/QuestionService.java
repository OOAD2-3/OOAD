package com.ooad.demo.service;

import com.ooad.demo.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 13:25 2018/12/2
 * @Modified by:
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    /**
     * @Author: WinstonDeng
     * @Description:  新增某一节讨论课某组的提问分数(讨论课进行中打分)
     * @Date: 13:25 2018/12/2
     */
    public boolean addQuestionScoreBySeminarIdAndTeamId(int seminarId,int teamId, float questionScore){
        //假设库里存的都是被提问的，所以库字段is_ask应该删掉，
        //判断是否被问只在提问环节进行（若在库中有记录，则已提问过，这个能不能多次提问具体需要看规则）
        //假设可以多次提问，直接新增一条记录
        return questionDao.addQuestionScoreBySeminarIdAndTeamId(seminarId, teamId, questionScore);
    }
}
