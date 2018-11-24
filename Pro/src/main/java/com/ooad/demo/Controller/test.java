package com.ooad.demo.Controller;

import com.ooad.demo.Domain.Teacher;
import com.ooad.demo.Service.TeacherSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class test {
    @Autowired
    TeacherSevice teacherSevice;

    @RequestMapping(value = "/Teacher",method = RequestMethod.GET)
    @ResponseBody
    public int getTeacherById(){
        System.out.println("get");
        return 1;
    }

    @RequestMapping(value = "/Teacher",method = RequestMethod.POST)
    @ResponseBody
    public void post(){
        System.out.println("post");
    }

    @RequestMapping(value = "/Teacher",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(){
        System.out.println("delete");
    }
}
