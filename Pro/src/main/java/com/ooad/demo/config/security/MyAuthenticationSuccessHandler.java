package com.ooad.demo.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooad.demo.pojo.RespInfo;
import com.ooad.demo.utils.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


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

        String username=(String) authentication.getPrincipal();

        String url="/common/test?username="+username;

        //httpServletResponse.sendRedirect(url);

        RespInfo respInfo=new RespInfo();
        respInfo.setStatus(200);
        respInfo.setMsg("Login Success!");

        //生成token
        String jwtToken = JwtTokenUtil.generateToken(username, 300);
        respInfo.setJwtToken(jwtToken);

        httpServletResponse.setHeader("wangshiqi", "success");

        httpServletResponse.setContentType("application/json;charset=utf-8");
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = httpServletResponse.getWriter();
        out.write(om.writeValueAsString(respInfo));
        out.flush();
        out.close();

        //httpServletResponse.getWriter().write(JSON.toJSONString(respInfo));
    }
}
