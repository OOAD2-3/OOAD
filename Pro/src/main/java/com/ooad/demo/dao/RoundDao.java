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
     * 讨论课信息
     */
    public static final int HAS_SEMINARS = 0;
    /**
     * 课程信息
     */
    public static final int HAS_COURSE = 1;

    /**
     * Description: 通过Id获取该轮次的信息，和轮次里的所有讨论课
     *
     * @Author:17Wang
     * @Time: 23:37 2018/11/29
     */
    public Round getById(int id, int... hasSomething) {
        Round round = roundMapper.findById(id);

        for (int i : hasSomething) {
            if (i == HAS_SEMINARS) {
                List<Seminar> seminars = seminarMapper.findByRoundId(id);
                round.setSeminars(seminars);
            }
            if (i == HAS_COURSE) {
                Course course = courseMapper.findById(round.getCourseId());
                round.setCourse(course);
            }
        }

        return round;
    }

    /**
     * Description: 通过courseId获取该课程下的所有轮次，和轮次里的所有讨论课
     *
     * @Author:17Wang
     * @Time: 23:36 2018/11/29
     */
    public List<Round> listByCourseId(int courseId, int... hasSomething) {
        List<Round> rounds = roundMapper.findByCourseId(courseId);

        for (Round round : rounds) {
            for (int i : hasSomething) {
                if (i == HAS_SEMINARS) {
                    List<Seminar> seminars = seminarMapper.findByRoundId(round.getId());
                    round.setSeminars(seminars);
                }
                if (i == HAS_COURSE) {
                    Course course = courseMapper.findById(round.getCourseId());
                    round.setCourse(course);
                }
            }
        }

        return rounds;
    }
}
