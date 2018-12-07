package com.ooad.demo.service;

import com.ooad.demo.dao.PresentationDao;
import com.ooad.demo.dao.TeamDao;
import com.ooad.demo.entity.Presentation;
import com.ooad.demo.entity.Team;
import com.ooad.demo.pojo.vo.ScoresUnderPresentationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private PresentationDao presentationDao;
    @Autowired
    private TeamDao teamDao;

    /**
     * @Description:将PresentationTeamBO转换成ScoresUnderPresentationVO前端需要的数据
     * @Author:17Wang
     * @Time:14:18 2018/12/2
     */
    public ScoresUnderPresentationVO listScoresUnderPresentationVOBySeminarIdAndCClassId(int seminarId, int cClassId) {
        List<Presentation> presentations = presentationDao.listBySeminarId(seminarId, false, true, true);
        List<Presentation> myPresentations = new ArrayList<>();

        for (Presentation presentation : presentations) {
            Team team = teamDao.getById(presentation.getTeamId(), false, false, false, true);

            //判断这个小组在不在这个班级下
            if (team.getcClassId() == cClassId) {
                myPresentations.add(presentation);
            }
        }

        return new ScoresUnderPresentationVO(myPresentations);
    }
}
