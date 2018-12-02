package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Presentation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 22:00 2018/11/29
 * @Modified by:
 */
@Mapper
@Repository
public interface PresentationMapper {

    //================查找==========================
    Presentation findById(Integer id);
    List<Presentation> findBySeminarId(Integer seminarId);
    List<Presentation> findByTeamId(Integer teamId);
    List<Presentation> findBycClassId(Integer cClassId);
    Presentation findByPreOrder(Integer preOrder);


    //================修改==========================
    void updateReportScore(Presentation presentation);
}
