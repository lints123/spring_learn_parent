package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ResponseController {

    // http://localhost:8080/spring-mvc/res1
    @GetMapping("/res1")
    @ResponseBody
    public User res1() {
        System.out.println("res1");
        return new User("zhangsan", 20);
    }

}
