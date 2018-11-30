package com.ooad.demo.Mapper;

import com.ooad.demo.Entity.Team;
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
    Team findById(Integer id);
    List<Team> findBycClassId(Integer cClassId);

}
