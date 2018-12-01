package com.ooad.demo.Service;

import com.ooad.demo.Dao.PresentationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @Author: WinstonDeng
     * @Description:  报告材料界面 打分
     *                 展示记录id presentationId
     *                 报告分数 reportScore
     * @Date: 0:08 2018/12/2
     */
    public boolean setReportScoreByPresentationId(int presentationId,float reportScore){
        return presentationDao.updatePresentationReportScoreById(presentationId, reportScore);

    }
}
