package com.ooad.demo.Controller;


import com.ooad.demo.Service.SeminarService;
import com.ooad.demo.VO.PreFileDownloadVO;
import com.ooad.demo.VO.SeminarPreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    SeminarService seminarService;

    @RequestMapping(value = "/presentations/{seminarId}/entrance", method = RequestMethod.GET)
    @ResponseBody
    public SeminarPreVO SeminarPreVOInPrePage(@PathVariable("seminarId") int seminarId){
        return seminarService.getSeminarPreVOBySeminarId(seminarId);
    }

    @RequestMapping(value = "/presentations/{seminarId}/downloadPreFiles",method = RequestMethod.GET)
    @ResponseBody
    public PreFileDownloadVO SeminarPreFileDownloadPage(@PathVariable("seminarId") int seminarId){
        return seminarService.getPreFileDownLoadVOBySeminarId(seminarId);
    }
}
