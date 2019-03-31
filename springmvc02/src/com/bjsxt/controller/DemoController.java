package com.bjsxt.controller;

import com.bjsxt.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String demo(People people){
        System.out.println("执行的demo调用" + people.toString());
        return "main.jsp";
    }
}
