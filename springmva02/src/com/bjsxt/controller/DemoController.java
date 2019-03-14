package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String Demo(){
        System.out.println("执行demo");
        return "main.jsp";
    }
}
