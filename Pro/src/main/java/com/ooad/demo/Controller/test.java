package com.ooad.demo.Controller;

import com.ooad.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class test {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/Teacher",method = RequestMethod.GET)
    @ResponseBody
    public int getTeacherById(){
        System.out.println("get");
        return 1;
    }
}
