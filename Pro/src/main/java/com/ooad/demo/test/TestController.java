package com.ooad.demo.test;

import com.ooad.demo.config.jwt.JwtUser;
import com.ooad.demo.config.jwt.JwtUserDetailsService;
import com.ooad.demo.dao.MenuDao;
import com.ooad.demo.dao.UserDao;
import com.ooad.demo.entity.Menu;
import com.ooad.demo.entity.User;
import com.ooad.demo.pojo.RespInfo;
import com.ooad.demo.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 22:21 2018/12/7
 * Description:
 */
@RestController
@RequestMapping("/common")
public class TestController {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @GetMapping("/test")
    @ResponseBody
    public RespInfo test(@RequestParam("username") String username){
        RespInfo respInfo=new RespInfo();
        respInfo.setStatus(200);
        respInfo.setMsg("Login Success!");

        //生成token
        String jwtToken = JwtTokenUtil.generateToken(username, 300);
        respInfo.setJwtToken(jwtToken);

        return respInfo;
    }

    @GetMapping("/test1")
    @ResponseBody
    public JwtUser test1(@RequestParam("username") String username){
        return jwtUserDetailsService.loadUserByUsername(username);
    }

    @GetMapping("/test2")
    @PreAuthorize("hasRole('ROLE_teacher')")
    @ResponseBody
    public JwtUser test2(@RequestParam("username") String username){
        return jwtUserDetailsService.loadUserByUsername(username);
    }
}
