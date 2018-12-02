package com.ooad.demo.Service;

import com.ooad.demo.Dao.PresentationDao;
import com.ooad.demo.POJO.BO.PresentationTeamBO;
import com.ooad.demo.POJO.VO.ScoresUnderPresentationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 0:17 2018/12/2
 * @Modified by:
 */

@Service
public class PresentationService {
    @Autowired
    PresentationDao presentationDao;

    /**
     * @Description:将PresentationTeamBO转换成ScoresUnderPresentationVO前端需要的数据
     * @Author:17Wang
     * @Time:14:18 2018/12/2
    */
    public ScoresUnderPresentationVO listScoresUnderPresentationVOBySeminarIdAndCClassId(int seminarId,int cClassId){
        return new ScoresUnderPresentationVO(presentationDao.listPresentationTeamBOBySeminarIdAndCClassId(seminarId, cClassId));
    }
}
