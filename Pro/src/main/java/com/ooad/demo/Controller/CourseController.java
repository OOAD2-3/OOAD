package com.ooad.demo.Controller;

import com.ooad.demo.Service.CourseService;
import com.ooad.demo.VO.SeminarsOverviewVO;
import com.ooad.demo.VO.SeminarsUnderRoundsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    /**
     * @Description:暂时使用的参数
     * @Author:17Wang
     * @Time:14:07 2018/11/28
    */
    private final int teacherId=1;

    @Autowired
    CourseService courseService;

    /**
     * @Description:快捷进入讨论课界面需要的数据
     * @Author:17Wang
     * @Time:14:11 2018/11/28
     */
    @RequestMapping(value = "/seminars/entrance",method = RequestMethod.GET)
    @ResponseBody
    public List<SeminarsOverviewVO> SeminarOverviewInCoursePage(){
        return courseService.listSeminarsOverviewVOByTeacherId(teacherId);
    }

    /**
     * @Description:进入一个课程 显示该课程的所有已有轮次和轮次下的所有讨论课
     * @Author:17Wang
     * @Time:16:54 2018/11/30
    */
    @RequestMapping(value = "/seminars/{courseid}/entrance",method = RequestMethod.GET)
    @ResponseBody
    public SeminarsUnderRoundsVO RoundsInCoursePage(@PathVariable("courseid") int courseId){
        return courseService.SeminarsUnderRoundsVOByCourseId(courseId);
    }
}
