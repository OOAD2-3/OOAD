package com.ooad.demo.config.security;

import com.alibaba.fastjson.JSON;
import com.ooad.demo.utils.JwtTokenUtil;
import com.ooad.demo.pojo.RespInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 12:24 2018/12/10
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        RespInfo respInfo=new RespInfo();

        respInfo.setStatus(200);
        respInfo.setMsg("Login Success!");

        String username=(String) authentication.getPrincipal();

        //生成token
        String jwtToken = JwtTokenUtil.generateToken(username, 300);
        respInfo.setJwtToken(jwtToken);

        httpServletResponse.getWriter().write(JSON.toJSONString(respInfo));
    }
}
