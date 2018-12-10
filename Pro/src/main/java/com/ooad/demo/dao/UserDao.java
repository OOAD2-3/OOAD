package com.ooad.demo.dao;

import com.ooad.demo.entity.User;
import com.ooad.demo.mapper.CourseMapper;
import com.ooad.demo.mapper.RoleMapper;
import com.ooad.demo.mapper.TeamMapper;
import com.ooad.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * Description:通过id查询User 暂未完成
     *
     * @Author: 17Wang
     * @Time: 15:35 2018/12/7
     */
    public User getById(int id, boolean hasCourses, boolean hasTeam) {
        User user = userMapper.findById(id);

        if (hasCourses) {
            //这里需要连关系表course_student
            //待完成
        }
        if (hasTeam) {
            //这里需要连关系表team_student
            //待完成
        }

        return user;
    }

    /**
     * Description:通过userid查询user 暂未完成
     *
     * @Author: 17Wang
     * @Time: 15:45 2018/12/7
     */
    public User getByAccount(String account, boolean hasCourses, boolean hasTeam) {
        User user = userMapper.findByAccount(account);

        if (hasCourses) {
            //这里需要连关系表course_student
            //待完成
        }
        if (hasTeam) {
            //这里需要连关系表team_student
            //待完成
        }

        return user;
    }

    /**
     * Description:
     * @Author: 17Wang
     * @Time: 22:22 2018/12/7
     */
    public User getUserRoleById(int userId){
        return userMapper.findUserRoleByUserId(userId);
    }

    public User getUserRoleByUsername(String username){
        return userMapper.findUserRoleByUsername(username);
    }
}
