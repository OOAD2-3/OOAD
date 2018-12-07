package com.ooad.demo.dao;

import com.ooad.demo.entity.Course;
import com.ooad.demo.entity.Round;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.mapper.CourseMapper;
import com.ooad.demo.mapper.RoundMapper;
import com.ooad.demo.mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Component
public class RoundDao {
    @Autowired
    private RoundMapper roundMapper;

    @Autowired
    private SeminarMapper seminarMapper;

    @Autowired
    private CourseMapper courseMapper;

    /**
     * Description: 通过Id获取该轮次的信息，和轮次里的所有讨论课
     *
     * @Author:17Wang
     * @Time: 23:37 2018/11/29
     */
    public Round getById(int id, boolean hasSeminars, boolean hasCourse) {
        Round round = roundMapper.findById(id);

        if (hasSeminars) {
            List<Seminar> seminars = seminarMapper.findByRoundId(round.getId());
            round.setSeminars(seminars);
        }
        if (hasCourse) {
            Course course = courseMapper.findById(round.getCourseId());
            round.setCourse(course);
        }

        return round;
    }

    /**
     * Description: 通过courseId获取该课程下的所有轮次，和轮次里的所有讨论课
     *
     * @Author:17Wang
     * @Time: 23:36 2018/11/29
     */
    public List<Round> listByCourseId(int courseId, boolean hasSeminars, boolean hasCourse) {
        List<Round> rounds = roundMapper.findByCourseId(courseId);

        for (Round round : rounds) {
            if (hasSeminars) {
                List<Seminar> seminars = seminarMapper.findByRoundId(round.getId());
                round.setSeminars(seminars);
            }
            if (hasCourse) {
                Course course = courseMapper.findById(round.getCourseId());
                round.setCourse(course);
            }
        }

        return rounds;
    }
}
