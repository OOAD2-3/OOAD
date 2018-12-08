package com.ooad.demo.test;

import com.ooad.demo.dao.UserDao;
import com.ooad.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 17Wang
 * @Date: 22:21 2018/12/7
 * Description:
 */
@RestController
public class TestController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/test")
    @ResponseBody
    public User test(@RequestParam("userid") int userId){
        System.out.println(1);
        return userDao.getUserRoleById(userId);
    }

    @GetMapping("/test1")
    @ResponseBody
    public User test1(@RequestParam("userid") int userId, HttpServletRequest request, HttpServletResponse response){
        return userDao.getById(userId, false, false);
    }
}
