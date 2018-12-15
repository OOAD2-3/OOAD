package com.ooad.demo.service;

import com.ooad.demo.entity.User;
import com.ooad.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    /**
     * Description:登录判断
     * @Author:17Wang
     * @Time:23:45 2018/12/4
    */
    public boolean login(String userAccount, String password){
        User user=userMapper.findByAccount(userAccount);

        //如果查询不到，说明账号输入错误，不存在该用户，登录失败，返回false
        if(user==null) {
            return false;
        }
        //登录成功以后还要设置session信息，暂时不做
        else if(user.getPassword().equals(password)){
            return true;
            //。。。
        }

        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.findByAccount(s);
        if (user==null){
            throw new UsernameNotFoundException("用户名不对");
        }

        return user;
    }
}
