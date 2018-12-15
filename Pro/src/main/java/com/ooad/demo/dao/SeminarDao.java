package com.ooad.demo.dao;

import com.ooad.demo.entity.Course;
import com.ooad.demo.entity.Presentation;
import com.ooad.demo.entity.Round;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.mapper.CourseMapper;
import com.ooad.demo.mapper.PresentationMapper;
import com.ooad.demo.mapper.RoundMapper;
import com.ooad.demo.mapper.SeminarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * Description:
 */
@Component
public class SeminarDao {
    @Autowired
    private SeminarMapper seminarMapper;

    @Autowired
    private PresentationMapper presentationMapper;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private RoundMapper roundMapper;

    /**
     * 展示信息
     */
    public static final int HAS_PRESENTATIONS = 0;
    /**
     * 课程信息
     */
    public static final int HAS_COURSE = 1;
    /**
     * 轮次信息
     */
    public static final int HAS_ROUND = 2;

    /**
     * Description:
     *
     * @Author: 17Wang
     * @Time: 14:52 2018/12/7
     */
    public Seminar getById(int seminarId, int... hasSomething) {
        Seminar seminar = seminarMapper.findById(seminarId);

        for (int i : hasSomething) {
            if (i == HAS_PRESENTATIONS) {
                List<Presentation> presentations = presentationMapper.findBySeminarId(seminarId);
                seminar.setPresentations(presentations);
            }
            //从课程问题，待改动
            if (i == HAS_COURSE) {
                Course course = courseDao.getById(seminar.getCourseId(), CourseDao.HAS_CLASSES);
                seminar.setCourse(course);
            }
            if (i == HAS_ROUND) {
                Round round = roundMapper.findById(seminar.getRoundId());
                seminar.setRound(round);
            }
        }


        return seminar;
    }

    /**
     * Description:
     *
     * @Author: 17Wang
     * @Time: 14:52 2018/12/7
     */
    public List<Seminar> listByCourseId(int courseId, int... hasSomething) {
        List<Seminar> seminars = seminarMapper.findByCourseId(courseId);

        for (Seminar seminar : seminars) {
            for (int i : hasSomething) {
                if (i == HAS_PRESENTATIONS) {
                    List<Presentation> presentations = presentationMapper.findBySeminarId(seminar.getId());
                    seminar.setPresentations(presentations);
                }
                //从课程问题，待改动
                if (i == HAS_COURSE) {
                    Course course = courseDao.getById(seminar.getCourseId(), CourseDao.HAS_CLASSES);
                    seminar.setCourse(course);
                }
                if (i == HAS_ROUND) {
                    Round round = roundMapper.findById(seminar.getRoundId());
                    seminar.setRound(round);
                }
            }
        }

        return seminars;
    }

    /**
     * Description: 通过轮次搜索该轮次下的讨论课
     *
     * @Author: 17Wang
     * @Time: 22:55 2018/12/5
     */
    public List<Seminar> listByRoundId(int roundId, int... hasSomething) {
        List<Seminar> seminars = seminarMapper.findByRoundId(roundId);

        for (Seminar seminar : seminars) {
            for (int i : hasSomething) {
                if (i == HAS_PRESENTATIONS) {
                    List<Presentation> presentations = presentationMapper.findBySeminarId(seminar.getId());
                    seminar.setPresentations(presentations);
                }
                //从课程问题，待改动
                if (i == HAS_COURSE) {
                    Course course = courseDao.getById(seminar.getCourseId(), CourseDao.HAS_CLASSES);
                    seminar.setCourse(course);
                }
                if (i == HAS_ROUND) {
                    Round round = roundMapper.findById(seminar.getRoundId());
                    seminar.setRound(round);
                }
            }
        }

        return seminars;
    }
}
