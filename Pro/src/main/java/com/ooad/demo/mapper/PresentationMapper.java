package com.ooad.demo.mapper;

import com.ooad.demo.entity.Presentation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    /**
     * 通过seminarId查找表所有字段
     * @param seminarId
     * @return List<Presentation>
     */
    List<Presentation> findBySeminarId(Integer seminarId);
    /**
     * 通过teamId查找表所有字段
     * @param teamId
     * @return List<Presentation>
     */
    List<Presentation> findByTeamId(Integer teamId);
    /**
     * 通过cClassId查找表所有字段
     * @param cClassId
     * @return List<Presentation>
     */
    List<Presentation> findBycClassId(Integer cClassId);
    /**
     * 通过preOrder查找表所有字段
     * @param preOrder
     * @return Presentation
     */
    Presentation findByPreOrder(Integer preOrder);
    /**
     * 通过seminarId和teamId查找表所有字段
     * @param seminarId
     * @param teamId
     * @return Presentation
     */
    Presentation findBySeminarIdAndTeamId(@Param("seminarId") Integer seminarId, @Param("teamId") Integer teamId);

    //================修改==========================
    /**
     * 通过presentation修改表的report_score
     * @param presentation
     */
    void updateReportScore(Presentation presentation);
    /**
     * 通过presentation修改表的pre_score
     * @param presentation
     */
    void updatePreScore(Presentation presentation);
}
