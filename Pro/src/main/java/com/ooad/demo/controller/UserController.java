package com.ooad.demo.controller;

import com.ooad.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public boolean login(@RequestParam("userid") String userId,@RequestParam("passname") String passName) {
        return userService.login(userId, passName);
    }
}
