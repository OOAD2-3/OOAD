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
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Description:登录接口，自动判断当前是学生还是老师
     * @Author: 17Wang
     * @Time:11:27 2018/12/5
    */
    @GetMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam("userid") String userId, @RequestParam("password") String password) {
        return userService.login(userId, password);
    }

    /**
     * Description:测试接口1
     * @Author: 17Wang
     * @Time:11:27 2018/12/5
    */
    @PostMapping("/login")
    @ResponseBody
    public String test1(@RequestParam("username") String name,@RequestParam("password") String password){
        return "!@3";
    }

    /**
     * Description:测试接口2
     * @Author: 17Wang
     * @Time: 21:14 2018/12/5
    */
    @GetMapping("/test")
    @ResponseBody
    public String test2(){
        return "!@3";
    }
}
