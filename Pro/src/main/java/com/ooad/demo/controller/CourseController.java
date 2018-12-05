package com.ooad.demo.controller;

import com.ooad.demo.service.CourseService;

import com.ooad.demo.pojo.vo.SeminarsOverviewVO;
import com.ooad.demo.pojo.vo.SeminarsUnderRoundsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    /**
     * @Description:暂时使用的参数
     * @Author:17Wang
     * @Time:14:07 2018/11/28
    */
    private final int tempTeacherId=1;

    @Autowired
    CourseService courseService;

    /**
     * @Description:快捷进入讨论课界面需要的数据
     * @Author:17Wang
     * @Time:14:11 2018/11/28
     */
    @GetMapping(value = "/seminars")
    @ResponseBody
    public List<SeminarsOverviewVO> SeminarOverviewInCoursePage(){
        return courseService.listSeminarsOverviewVOByTeacherId(tempTeacherId);
    }

    /**
     * @Description:进入一个课程 显示该课程的所有已有轮次和轮次下的所有讨论课
     * @Author:17Wang
     * @Time:16:54 2018/11/30
    */
    @GetMapping(value = "/{courseid}/seminars")
    @ResponseBody
    public SeminarsUnderRoundsVO RoundsInCoursePage(@PathVariable("courseid") int courseId){
        return courseService.SeminarsUnderRoundsVOByCourseId(courseId);
    }


}
