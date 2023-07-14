package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // http://localhost:8080/spring-mvc/param?userName=zhangsan
    @GetMapping("/param")
    public String param(String userName) {
        System.out.println("param >>> userName = " + userName);
        // forward:/index.jsp    转发
        // redirect:/index.jsp   重定向
        return "/index.jsp";
    }

    // http://localhost:8080/spring-mvc/param1?userName=zhangsan&age=20
    @GetMapping("/param1")
    public String param1(User user) {
        System.out.println("param1 >>> ");
        return "/index.jsp";
    }

}
