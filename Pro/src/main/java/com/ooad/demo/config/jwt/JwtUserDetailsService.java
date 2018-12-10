package com.ooad.demo.config.jwt;

import com.ooad.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 10:21 2018/12/10
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public JwtUser loadUserByUsername(String s) throws UsernameNotFoundException {

        if (userDao.getUserRoleByUsername(s) == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new JwtUser(userDao.getUserRoleByUsername(s));
    }
}
