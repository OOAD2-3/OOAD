package com.ooad.demo.Service;

import com.ooad.demo.Dao.CourseDao;
import com.ooad.demo.Entity.Course;
import com.ooad.demo.VO.SeminarOverviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;

    /**
     * @Description:给讨论课总界面使用的VO
     * @Author:17Wang
     * @Time:0:01 2018/11/28
    */
    public List<SeminarOverviewVO> listSeminarOverviewVOByTeacherId(int teacherId){
        List<SeminarOverviewVO> seminarOverviewVOS=new ArrayList<>();
        List<Course> courses=courseDao.listByTeacherId(teacherId, true, false, true);
        for (Course course:
             courses) {
            seminarOverviewVOS.add(new SeminarOverviewVO(course));
        }

        return seminarOverviewVOS;
    }

}
