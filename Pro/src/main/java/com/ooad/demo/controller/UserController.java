package com.ooad.demo.controller;

import com.ooad.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:17Wang
 * @Date:22:20 2018/12/4
 * @Description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Description:登录接口，自动判断当前是学生还是老师
     * @Author: 17Wang
     * @Time:11:27 2018/12/5
    */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public boolean login(@RequestParam("userid") String userId, @RequestParam("password") String password) {
        return userService.login(userId, password);
    }

    /**
     * Description:测试接口
     * @Author: 17Wang
     * @Time:11:27 2018/12/5
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestParam("username") String name,@RequestParam("password") String password){
        return "!@3";
    }
}
