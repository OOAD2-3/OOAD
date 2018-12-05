package com.ooad.demo.controller;


import com.ooad.demo.service.SeminarService;

import com.ooad.demo.pojo.vo.PreFileDownloadVO;

import com.ooad.demo.pojo.vo.ReportFileDownloadVO;
import com.ooad.demo.pojo.vo.SeminarInfoVO;
import com.ooad.demo.pojo.vo.SeminarSubInfoVO;
import com.ooad.demo.pojo.vo.SeminarPreVO;

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

    //private final int seminarId=1;

    private final int tempSeminarId=1;


    @Autowired
    SeminarService seminarService;

    /**
     * @Author: WinstonDeng
     * @Description: 正在进行的讨论课界面展示的信息
     * @Date: 22:59 2018/12/1
     */
    @GetMapping(value = "/{seminarid}/cclasses/{cclassid}/presentations")
    @ResponseBody
    public SeminarPreVO SeminarPreVOInPrePage(@PathVariable("seminarid") int seminarId,@PathVariable("cclassid") int cClassId){
        return seminarService.getSeminarPreVOBySeminarIdAndCClassId(seminarId,cClassId);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 讨论课展示材料ppt下载界面展示的信息
     * @Date: 23:00 2018/12/1
     */
    @GetMapping(value = "/{seminarid}/presentations/prefiles")
    @ResponseBody
    public PreFileDownloadVO SeminarPreFileDownloadPage(@PathVariable("seminarid") int seminarId){
        return seminarService.getPreFileDownLoadVOBySeminarId(seminarId);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 讨论课结束后报告材料下载界面展示的信息
     * @Date: 23:01 2018/12/1
     */
    @GetMapping(value = "/{seminarid}/presentations/reportfiles")
    @ResponseBody
    public ReportFileDownloadVO SeminarReportFileDownloadPage(@PathVariable("seminarid") int seminarId){
        return seminarService.getReportFileDownliadVOBySeminarId(seminarId);
    }


    /**
     * @Description:进入讨论课前显示的讨论课信息
     * @Author:17Wang
     * @Time:20:53 2018/12/1
    */
    @GetMapping(value = "/{seminarid}/subinfo")
    @ResponseBody
    public SeminarSubInfoVO seminarSubInfoIVO(@PathVariable("seminarid") int seminarId){
        return seminarService.getSeminarSubInfoVOBySeminarId(seminarId);
    }

    /**
     * @Description:返回一个Seminar的所有信息
     * @Author:17Wang
     * @Time:21:12 2018/12/1
    */
    @GetMapping(value = "/{seminarid}")
    @ResponseBody
    public SeminarInfoVO seminarById(@PathVariable("seminarid") int seminarId){
        return seminarService.getSeminarInfoVOBySeminarId(seminarId);

    }
}
