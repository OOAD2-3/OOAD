package com.ooad.demo.controller;

import com.ooad.demo.controller.handler.ErrorInfo;
import com.ooad.demo.controller.handler.MyException;
import com.ooad.demo.entity.CClass;
import com.ooad.demo.entity.Course;
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
    private final int tempTeacherId = 1;

    @Autowired
    CourseService courseService;

    /**
     * Description: 新建课程
     *
     * @Author: 17Wang
     * @Time: 17:10 2018/12/12
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Boolean> addCourse(@RequestBody Course course) throws MyException {
        return ResponseEntity.status(201).body(courseService.addCourse(course));
    }

    /**
     * Description: 删除课程
     *
     * @Author: 17Wang
     * @Time: 17:10 2018/12/12
     */
    @DeleteMapping("/{courseId}")
    @ResponseBody
    public ResponseEntity<Boolean> deleteCourse(@PathVariable("courseId") int courseId) throws MyException {
        return ResponseEntity.status(204).body(courseService.deleteById(courseId));
    }

    /**
     * @Description:快捷进入讨论课界面需要的数据
     * @Author:17Wang
     * @Time:14:11 2018/11/28
     */
    @GetMapping("/seminars")
    @ResponseBody
    public List<SeminarsOverviewVO> SeminarOverviewInCoursePage() {
        return courseService.listSeminarsOverviewVOByTeacherId(tempTeacherId);
    }

    /**
     * @Description: 进入一个课程 显示该课程的所有已有轮次和轮次下的所有讨论课
     * @Author:17Wang
     * @Time:16:54 2018/11/30
     */
    @GetMapping("/{courseid}/seminars")
    @ResponseBody
    public SeminarsUnderRoundsVO RoundsInCoursePage(@PathVariable("courseid") int courseId) {
        return courseService.SeminarsUnderRoundsVOByCourseId(courseId);
    }

    /**
     * Description: 课程下新建班级
     *
     * @Author: WinstonDeng
     * @Date: 11:11 2018/12/12
     */
    @PostMapping("/{courseId}/class")
    @ResponseBody
    public ResponseEntity<Boolean> createcClassInCoursePage(@PathVariable("courseId") int courseId, @RequestBody CClass cClass) {
        boolean flag;
        try {
            flag = courseService.createCClass(courseId, cClass);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(false);
        }
        return ResponseEntity.ok().body(flag);
    }


}
