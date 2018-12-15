package com.ooad.demo.dao;

import com.ooad.demo.entity.CClass;
import com.ooad.demo.entity.Course;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.entity.Team;
import com.ooad.demo.mapper.CClassMapper;
import com.ooad.demo.mapper.CourseMapper;
import com.ooad.demo.mapper.SeminarMapper;
import com.ooad.demo.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 14:39 2018/12/7
 * Description:
 */
@Component
public class CClassDao {
    @Autowired
    private CClassMapper cClassMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private SeminarMapper seminarMapper;

    @Autowired
    private CourseMapper courseMapper;

    /**
     * Description:
     *
     * @Author: 17Wang
     * @Time: 14:42 2018/12/7
     */
    public CClass getById(int id, boolean hasTeams, boolean hasSeminars, boolean hasCourse) {
        CClass cClass = cClassMapper.findById(id);

        if (hasTeams) {
            List<Team> teams = teamMapper.findBycClassId(id);
            cClass.setTeams(teams);
        }
        if (hasSeminars) {
            List<Seminar> seminars=seminarMapper.findByCourseId(cClass.getCourseId());
            cClass.setSeminars(seminars);
        }
        if (hasCourse) {
            Course course=courseMapper.findById(cClass.getCourseId());
            cClass.setCourse(course);
        }

        return cClass;
    }

    /**
     * Description:
     *
     * @Author: 17Wang
     * @Time: 15:00 2018/12/7
     */
    public List<CClass> listByCourseId(int courseId, boolean hasTeams, boolean hasSeminars, boolean hasCourse) {
        List<CClass> cClasses = cClassMapper.findByCourseId(courseId);

        for (CClass cClass : cClasses) {
            if (hasTeams) {
                List<Team> teams = teamMapper.findBycClassId(cClass.getId());
                cClass.setTeams(teams);
            }
            if (hasSeminars) {
                List<Seminar> seminars=seminarMapper.findByCourseId(cClass.getCourseId());
                cClass.setSeminars(seminars);
            }
            if (hasCourse) {
                Course course=courseMapper.findById(cClass.getCourseId());
                cClass.setCourse(course);
            }
        }

        return cClasses;
    }

}
