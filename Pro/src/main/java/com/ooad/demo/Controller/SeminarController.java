package com.ooad.demo.Controller;


import com.ooad.demo.Dao.SeminarDao;
import com.ooad.demo.Entity.Seminar;
import com.ooad.demo.Service.SeminarService;
import com.ooad.demo.VO.SeminarInfoVO;
import com.ooad.demo.VO.SeminarSubInfoVO;
import com.ooad.demo.VO.SeminarPreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 9:16 2018/11/30
 * @Modified by:
 */

@RestController
@RequestMapping("/seminars")
public class SeminarController {

    /**
     * @Author: WinstonDeng
     * @Description: 临时参数
     * @Date: 16:02 2018/11/30
     */
    private final int tempSeminarId=1;

    @Autowired
    SeminarService seminarService;

    @RequestMapping(value = "/presentations/pre", method = RequestMethod.GET)
    @ResponseBody
    public SeminarPreVO SeminarPreVOInPrePage(){
        return seminarService.getSeminarPreVOBySeminarId(tempSeminarId);
    }


    /**
     * @Description:进入讨论课前显示的讨论课信息
     * @Author:17Wang
     * @Time:20:53 2018/12/1
    */
    @RequestMapping(value = "/{seminarid}/subinfo",method = RequestMethod.GET)
    @ResponseBody
    public SeminarSubInfoVO seminarSubInfoIVO(@PathVariable("seminarid") int seminarId){
        return seminarService.getSeminarSubInfoVOBySeminarId(seminarId);
    }

    /**
     * @Description:返回一个Seminar的所有信息
     * @Author:17Wang
     * @Time:21:12 2018/12/1
    */
    @RequestMapping(value = "/{seminarid}",method = RequestMethod.GET)
    @ResponseBody
    public SeminarInfoVO seminarById(@PathVariable("seminarid") int seminarId){
        return seminarService.getSeminarInfoVOBySeminarId(seminarId);
    }
}
