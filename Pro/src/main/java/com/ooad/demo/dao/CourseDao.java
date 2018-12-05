package com.ooad.demo.dao;

import com.ooad.demo.entity.CClass;
import com.ooad.demo.entity.Course;
import com.ooad.demo.entity.Round;
import com.ooad.demo.entity.Seminar;
import com.ooad.demo.mapper.CClassMapper;
import com.ooad.demo.mapper.CourseMapper;
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
public class CourseDao {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CClassMapper cClassMapper;

    @Autowired
    RoundDao roundDao;

    @Autowired
    SeminarMapper seminarMapper;

    /**
     * @Description:通过teacherId获取该teacher下的所有Course，三个布尔值参数可以设置对应的查询表
     * @Author:17Wang
     * @Time:23:23 2018/11/27
    */
    public List<Course> listByTeacherId(int teacherId,boolean hasClass,boolean hasRound,boolean hasSeminar) {
        List<Course> courses = courseMapper.findByTeacherId(teacherId);

        for (Course course :
                courses) {
            if (hasClass) {
                List<CClass> cClasses = cClassMapper.findByCourseId(course.getId());
                course.setcClasses(cClasses);
            }
            if (hasRound) {
                List<Round> rounds = roundDao.listByCourseId(course.getId(), true);
                course.setRounds(rounds);
            }
            if (hasSeminar) {
                List<Seminar> seminars = seminarMapper.findByCourseId(course.getId());
                course.setSeminars(seminars);
            }
        }

        return courses;
    }

    /**
     * Description:通过id获取Course，三个布尔值参数可以设置对应的查询表
     * @Author:17Wang
     * @Time:14:44 2018/11/28
    */
    public Course getById(int id,boolean hasClass,boolean hasRound,boolean hasSeminar){
        Course course=courseMapper.findById(id);

        if (hasClass) {
            List<CClass> cClasses = cClassMapper.findByCourseId(course.getId());
            course.setcClasses(cClasses);
        }
        if (hasRound) {
            List<Round> rounds = roundDao.listByCourseId(course.getId(), true);
            course.setRounds(rounds);
        }
        if (hasSeminar) {
            List<Seminar> seminars = seminarMapper.findByCourseId(course.getId());
            course.setSeminars(seminars);
        }

        return course;
    }
}
