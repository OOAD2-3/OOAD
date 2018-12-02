package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Presentation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

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

    List<Presentation> findBySeminarId(Integer seminarId);
    List<Presentation> findByTeamId(Integer teamId);
    List<Presentation> findBycClassId(Integer cClassId);
    Presentation findByPreOrder(Integer preOrder);
    Presentation findBySeminarIdAndTeamId(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId);

    //================修改==========================
    void updateReportScore(Presentation presentation);
    void updatePreScore(Presentation presentation);
}
