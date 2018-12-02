package com.ooad.demo.Controller;


import com.ooad.demo.Service.SeminarService;

import com.ooad.demo.POJO.VO.PreFileDownloadVO;

import com.ooad.demo.POJO.VO.ReportFileDownloadVO;
import com.ooad.demo.POJO.VO.SeminarInfoVO;
import com.ooad.demo.POJO.VO.SeminarSubInfoVO;
import com.ooad.demo.POJO.VO.SeminarPreVO;

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
    @RequestMapping(value = "{seminarId}/presentations/", method = RequestMethod.GET)
    @ResponseBody
    public SeminarPreVO SeminarPreVOInPrePage(@PathVariable("seminarId") int seminarId){
        return seminarService.getSeminarPreVOBySeminarId(seminarId);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 讨论课展示材料ppt下载界面展示的信息
     * @Date: 23:00 2018/12/1
     */
    @RequestMapping(value = "{seminarId}/presentations/prefiles",method = RequestMethod.GET)
    @ResponseBody
    public PreFileDownloadVO SeminarPreFileDownloadPage(@PathVariable("seminarId") int seminarId){
        return seminarService.getPreFileDownLoadVOBySeminarId(seminarId);
    }

    /**
     * @Author: WinstonDeng
     * @Description: 讨论课结束后报告材料下载界面展示的信息
     * @Date: 23:01 2018/12/1
     */
    @RequestMapping(value = "{seminarId}/presentations/reportfiles",method = RequestMethod.GET)
    @ResponseBody
    public ReportFileDownloadVO SeminarReportFileDownloadPage(@PathVariable("seminarId") int seminarId){
        return seminarService.getReportFileDownliadVOBySeminarId(seminarId);
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
