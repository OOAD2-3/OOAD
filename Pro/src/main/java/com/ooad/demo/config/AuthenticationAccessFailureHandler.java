package com.ooad.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooad.demo.pojo.RespInfo;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 17Wang
 * @Date: 18:56 2018/12/5
 * Description:
 */
@Component
public class AuthenticationAccessFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        RespInfo respInfo = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            respInfo = RespInfo.error("账户名或者密码输入错误！");
        } else if (e instanceof LockedException) {
            respInfo = RespInfo.error("账户被锁定，请联系管理员！");
        } else if (e instanceof CredentialsExpiredException) {
            respInfo = RespInfo.error("密码过期，请联管理员！");
        } else if (e instanceof AccountExpiredException) {
            respInfo = RespInfo.error("账户被禁用，请联系管理员！");
        } else if (e instanceof DisabledException) {
            respInfo = RespInfo.error("账户被禁用，请联系管理员！");
        } else {
            respInfo = RespInfo.error("登录失败！");
        }
        respInfo.setStatus(401);
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter out = httpServletResponse.getWriter();
        out.write(objectMapper.writeValueAsString(respInfo));
        out.flush();
        out.close();
    }
}
