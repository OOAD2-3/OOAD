package com.ooad.demo.Dao;

import com.ooad.demo.Entity.Round;
import com.ooad.demo.Entity.Seminar;
import com.ooad.demo.Mapper.RoundMapper;
import com.ooad.demo.Mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.SequenceInputStream;
import java.util.List;

@Component
public class RoundDao {
    @Autowired
    RoundMapper roundMapper;

    @Autowired
    SeminarMapper seminarMapper;

    /**
     * @Description:通过courseId获取该课程下的所有轮次，和轮次里的所有讨论课
     * @Author:17Wang
     * @Time:23:36 2018/11/29
    */
    public List<Round> listByCourseId(int courseId,boolean hasSeminar){
        List<Round> rounds=roundMapper.findByCourseId(courseId);

        if(hasSeminar){
            for (Round round:
                 rounds) {
                List<Seminar> seminars=seminarMapper.findByRoundId(round.getId());
                round.setSeminars(seminars);
            }
        }

        return rounds;
    }

    /**
     * @Description:通过Id获取该轮次的信息，和轮次里的所有讨论课
     * @Author:17Wang
     * @Time:23:37 2018/11/29
    */
    public Round getById(int id,boolean hasSeminar){
        Round round=roundMapper.findById(id);

        if(hasSeminar){
            List<Seminar> seminars=seminarMapper.findByRoundId(round.getId());
            round.setSeminars(seminars);
        }

        return round;
    }
}
