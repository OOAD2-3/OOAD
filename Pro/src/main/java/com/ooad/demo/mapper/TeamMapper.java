package com.ooad.demo.mapper;

import com.ooad.demo.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 22:15 2018/11/29
 * @Modified by:
 */
@Mapper
@Repository
public interface TeamMapper {
    //=======================查找=====================
    /**
     * 通过id查找表的所有字段
     * @param id
     * @return Team
     */
    Team findById(Integer id);

    /**
     * 通过cClassId查找表的所有字段
     * @param cClassId
     * @return List<Team>
     */
    List<Team> findBycClassId(Integer cClassId);

}
