package com.ooad.demo.Controller;

import com.ooad.demo.Service.CourseService;
import com.ooad.demo.VO.SeminarsOverviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/presentation/entrance",method = RequestMethod.GET)
    @ResponseBody
    public List<SeminarsOverviewVO> SeminarOverviewInCoursePage(){
        return courseService.listSeminarOverviewVOByTeacherId(teacherId);
    }
    
}
