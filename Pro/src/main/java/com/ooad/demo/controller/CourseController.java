package com.ooad.demo.controller;

import com.ooad.demo.entity.CClass;
import com.ooad.demo.pojo.vo.CreateCClassVO;
import com.ooad.demo.service.CClassService;
import com.ooad.demo.service.CourseService;
import com.ooad.demo.pojo.vo.SeminarsOverviewVO;
import com.ooad.demo.pojo.vo.SeminarsUnderRoundsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    /**
     * @Description:暂时使用的参数
     * @Author:17Wang
     * @Time:14:07 2018/11/28
    */
    private final int tempTeacherId=1;

    @Autowired
    CourseService courseService;

    @Autowired
    CClassService cClassService;
    /**
     * @Description:快捷进入讨论课界面需要的数据
     * @Author:17Wang
     * @Time:14:11 2018/11/28
     */
    @GetMapping("/seminars")
    @ResponseBody
    public List<SeminarsOverviewVO> SeminarOverviewInCoursePage(){
        return courseService.listSeminarsOverviewVOByTeacherId(tempTeacherId);
    }

    /**
     * @Description:进入一个课程 显示该课程的所有已有轮次和轮次下的所有讨论课
     * @Author:17Wang
     * @Time:16:54 2018/11/30
    */
    @GetMapping("/{courseid}/seminars")
    @ResponseBody
    public SeminarsUnderRoundsVO RoundsInCoursePage(@PathVariable("courseid") int courseId){
        return courseService.SeminarsUnderRoundsVOByCourseId(courseId);
    }

    /**
     * Description: 课程下新建班级
     * @Author: WinstonDeng
     * @Date: 11:11 2018/12/12
     */
    /**
     *  初步想法先传文件，成功的话给前端一个文件名，然后创建班级时通过这个文件名去寻找文件并解析
     *  解析数据，存库建立关系
     */
    @PostMapping("/{courseId}/class")
    @ResponseBody
    public ResponseEntity<Integer> createcClassInCoursePage(@PathVariable("courseId") int courseId, @RequestBody CreateCClassVO createCClassVO){
        //初始化为-1 表示新建失败
        int cclassId=-1;
       try {
           //设置班级基本信息
           CClass cClass=new CClass();
           cClass.setCourseId(courseId);
           cClass.setName(createCClassVO.getName());
           cClass.setTime(createCClassVO.getTime());
           cClass.setPlace(createCClassVO.getClassroom());
           //获得新建的课程主键
           cclassId=cClassService.createCClass(courseId,cClass);
           //解析学生名单
           if(cclassId!=-1){
               //调用解析学生名单的函数
               cClassService.transStudentListFileToDataBase(cclassId,createCClassVO.getFileName());
           }
       }catch (Exception e){
           return ResponseEntity.status(401).body(cclassId);
       }
       return ResponseEntity.ok().body(cclassId);
    }
}
