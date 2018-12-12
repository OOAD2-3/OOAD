package com.ooad.demo.service;

import com.ooad.demo.dao.CClassDao;
import com.ooad.demo.dao.CourseDao;
import com.ooad.demo.dao.RoundDao;
import com.ooad.demo.entity.CClass;
import com.ooad.demo.entity.Course;
import com.ooad.demo.pojo.vo.SeminarsOverviewVO;
import com.ooad.demo.pojo.vo.SeminarsUnderRoundsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;

    @Autowired
    RoundDao roundDao;

    @Autowired
    CClassDao cClassDao;
    /**
     * Description: 给讨论课总界面使用的VO，该VO包括课程id和name，该课程下的班级id和name，该课程下的讨论课id和name
     *
     * @Author: 17Wang
     * @Time:0:01 2018/11/28
     */
    public List<SeminarsOverviewVO> listSeminarsOverviewVOByTeacherId(int teacherId) {
        List<SeminarsOverviewVO> seminarOverviewVOS = new ArrayList<>();
        List<Course> courses = courseDao.listByTeacherId(teacherId, true, true, true, false);
        for (Course course :
                courses) {

            //是否属于从课程，若为从课程应该转换成主课程的
            if (course.getMasterCourseId() == 0) {
                seminarOverviewVOS.add(new SeminarsOverviewVO(course));
            } else {
                Course subCourse = courseDao.getById(course.getMasterCourseId(), false, false, true, false);
                subCourse.setId(course.getId());
                subCourse.setName(course.getName());
                subCourse.setMasterCourseId(course.getMasterCourseId());
                subCourse.setcClasses(course.getcClasses());
                seminarOverviewVOS.add(new SeminarsOverviewVO(subCourse));
            }
        }

        return seminarOverviewVOS;
    }

    /**
     * Description: 给某个课程的讨论课界面使用的VO，该VO包括课程id和name，该课程下的班级id和name，该课程下的轮次和轮次所包括的讨论课
     * @Author:17Wang
     * @Time:23:49 2018/11/29
     */
    public SeminarsUnderRoundsVO SeminarsUnderRoundsVOByCourseId(int courseId) {
        Course course = courseDao.getById(courseId, true, true, false, false);
        SeminarsUnderRoundsVO seminarsUnderRoundsVOS = new SeminarsUnderRoundsVO(course);
        return seminarsUnderRoundsVOS;
    }
    /**
     * Description: 创建课程
     * @Author: WinstonDeng
     * @Date: 11:34 2018/12/12
     */
    public boolean createCClass(int courseId, CClass cClass){
        try {
            cClassDao.addCClass(courseId,cClass);
        }catch (Exception e){
            System.out.println("service error");
            return false;
        }
        return true;
    }

}
