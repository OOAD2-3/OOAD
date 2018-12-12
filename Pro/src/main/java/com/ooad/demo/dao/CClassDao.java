package com.ooad.demo.dao;

import com.ooad.demo.controller.handler.MyException;
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
     * 是否添加队伍信息
     */
    public static final int HAS_TEAMS = 0;
    /**
     * 是否添加讨论课信息
     */
    public static final int HAS_SEMINARS = 1;
    /**
     * 是否添加课程信息
     */
    public static final int HAS_COURSE = 2;

    /**
     * Description:
     *
     * @Author: 17Wang
     * @Time: 14:42 2018/12/7
     */
    public CClass getById(int id, int... hasSomething) {
        CClass cClass = cClassMapper.findById(id);

        for (int i : hasSomething) {
            if (i == HAS_TEAMS) {
                List<Team> teams = teamMapper.findBycClassId(id);
                cClass.setTeams(teams);
            }
            if (i == HAS_SEMINARS) {
                List<Seminar> seminars = seminarMapper.findByCourseId(cClass.getCourseId());
                cClass.setSeminars(seminars);
            }
            if (i == HAS_COURSE) {
                Course course = courseMapper.findById(cClass.getCourseId());
                cClass.setCourse(course);
            }
        }

        return cClass;
    }

    /**
     * Description:
     *
     * @Author: 17Wang
     * @Time: 15:00 2018/12/7
     */
    public List<CClass> listByCourseId(int courseId, int... hasSomething) {
        List<CClass> cClasses = cClassMapper.findByCourseId(courseId);

        for (CClass cClass : cClasses) {
            for (int i : hasSomething) {
                if (i == HAS_TEAMS) {
                    List<Team> teams = teamMapper.findBycClassId(cClass.getId());
                    cClass.setTeams(teams);
                }
                if (i == HAS_SEMINARS) {
                    List<Seminar> seminars = seminarMapper.findByCourseId(cClass.getCourseId());
                    cClass.setSeminars(seminars);
                }
                if (i == HAS_COURSE) {
                    Course course = courseMapper.findById(cClass.getCourseId());
                    cClass.setCourse(course);
                }
            }
        }

        return cClasses;
    }

    /**
     * Description: 新建班级
     *
     * @Author: WinstonDeng
     * @Date: 10:49 2018/12/12
     */
    public boolean addCClass(int courseId, CClass cClass) throws Exception {
        try {
            cClass.setCourseId(courseId);
            cClassMapper.insertcClass(cClass);
        } catch (Exception e) {
            throw new Exception("新建课程错误");
        }
        return true;
    }

    /**
     * Description: 删除班级
     *
     * @Author: 17Wang
     * @Time: 17:47 2018/12/12
     */
    public boolean deleteById(int id) throws MyException {
        if (getById(id) == null) {
            throw new MyException("删除班级失败！没有存在该id的行", MyException.NOT_FOUND_ERROR);
        } else {
            try {
                return cClassMapper.deleteById(id);
            } catch (Exception e) {
                throw new MyException("删除班级失败！数据库执行错误", MyException.NOT_FOUND_ERROR);
            }
        }
    }
}
