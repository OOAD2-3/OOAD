package com.ooad.demo.dao;

import com.ooad.demo.entity.*;
import com.ooad.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Component
public class CourseDao {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CClassMapper cClassMapper;

    @Autowired
    private SeminarMapper seminarMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoundMapper roundMapper;

    @Autowired
    private TeamMapper teamMapper;

    /**
     * 班级信息
     */
    public static final int HAS_CLASSES = 0;
    /**
     * 轮次信息
     */
    public static final int HAS_ROUNDS = 1;
    /**
     * 讨论课信息
     */
    public static final int HAS_SEMINARS = 2;
    /**
     * 教师信息
     */
    public static final int HAS_TEACHER = 3;


    /**
     * Description:通过id获取Course，三个布尔值参数可以设置对应的查询表
     *
     * @Author:17Wang
     * @Time:14:44 2018/11/28
     */
    public Course getById(int id, int... hasSomething) {
        Course course = courseMapper.findById(id);

        for (int i : hasSomething) {
            if (i == HAS_CLASSES) {
                List<CClass> cClasses = cClassMapper.findByCourseId(id);
                course.setcClasses(cClasses);
            }
            if (i == HAS_ROUNDS) {
                List<Round> rounds = roundMapper.findByCourseId(id);
                course.setRounds(rounds);
            }
            if (i == HAS_SEMINARS) {
                List<Seminar> seminars = seminarMapper.findByCourseId(id);
                course.setSeminars(seminars);
            }
            if (i == HAS_TEACHER) {
                User teacher = userMapper.findById(course.getTeacherId());
                course.setTeacher(teacher);
            }
        }

        return course;
    }

    /**
     * Description:通过teacherId获取该teacher下的所有Course，三个布尔值参数可以设置对应的查询表
     *
     * @Author:17Wang
     * @Time:23:23 2018/11/27
     */
    public List<Course> listByTeacherId(int teacherId, int... hasSomething) {
        List<Course> courses = courseMapper.findByTeacherId(teacherId);

        for (Course course : courses) {
            for (int i : hasSomething) {
                if (i == HAS_CLASSES) {
                    List<CClass> cClasses = cClassMapper.findByCourseId(course.getId());
                    course.setcClasses(cClasses);
                }
                if (i == HAS_ROUNDS) {
                    List<Round> rounds = roundMapper.findByCourseId(course.getId());
                    course.setRounds(rounds);
                }
                if (i == HAS_SEMINARS) {
                    List<Seminar> seminars = seminarMapper.findByCourseId(course.getId());
                    course.setSeminars(seminars);
                }
                if (i == HAS_TEACHER) {
                    User teacher = userMapper.findById(course.getTeacherId());
                    course.setTeacher(teacher);
                }
            }
        }

        return courses;
    }


}
