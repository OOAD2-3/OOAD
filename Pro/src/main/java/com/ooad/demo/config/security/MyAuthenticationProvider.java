package com.ooad.demo.config.security;

import com.ooad.demo.config.jwt.JwtUser;
import com.ooad.demo.config.jwt.JwtUserDetailsService;
import com.ooad.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 13:47 2018/12/10
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=(String) authentication.getPrincipal();
        String password=(String) authentication.getCredentials();

        JwtUser jwtUser=jwtUserDetailsService.loadUserByUsername(username);
        if(!jwtUser.getPassword().equals(password)){
            throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
        }

        return new UsernamePasswordAuthenticationToken(username, password, jwtUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
