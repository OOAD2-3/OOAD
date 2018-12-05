package com.ooad.demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooad.demo.pojo.RespInfo;
import com.ooad.demo.utils.UserUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 17Wang
 * @Date: 19:36 2018/12/5
 * Description:
 */
@Component
public class AuthenticationAccessSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        RespInfo respInfo=RespInfo.ok("登录成功！",UserUtils.getCurrentUser());
        ObjectMapper objectMapper=new ObjectMapper();
        PrintWriter out=httpServletResponse.getWriter();
        out.write(objectMapper.writeValueAsString(respInfo));
        out.flush();
        out.close();
    }
}
