package com.bjsxt.controller;

import com.bjsxt.pojo.Demo;
import com.bjsxt.pojo.Demo1;
import com.bjsxt.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String Demo(){
        System.out.println("执行demo");
        return "main.jsp";
    }

    @RequestMapping("demo1")
    public String Demo(String name,int age){
        System.out.println("姓名："+name +"年龄：" + age);
        return "main.jsp";
    }

    @RequestMapping("demo2")
    public String Demo1(@RequestParam(defaultValue = "张三") String name, @RequestParam(defaultValue = "1") int age){
        System.out.println("姓名："+name +"年龄：" + age);
        return "main.jsp";
    }

    @RequestMapping("demo3")
    public String Demo2(@RequestParam(required = true)String name,@RequestParam(required = false)int age){
        System.out.println("执行成功"+name +age);
        return "main.jsp";
    }

    @RequestMapping("demo4")
    public String Demo4(People people){
        System.out.println(people.toString());
        return "main.jsp";
    }

    @RequestMapping("demo5")
    public String demo5(People people,@RequestParam("hover") List<String> hover){
        System.out.println(people+""+hover);
        return "main.jsp";
    }

    @RequestMapping("demo6")
    public String demo6(Demo demo){
        System.out.println(demo);
        return "main.jsp";
    }

    @RequestMapping("demo7")
    public String demo7(Demo1 demo){
        System.out.println(demo);
        return "main.jsp";
    }

    @RequestMapping("demo8/{name}/{age1}")
    public String demo8(@PathVariable String name,@PathVariable("age1") int age){
        System.out.println(name+age);
        return "redirect:/main.jsp";
    }

    @RequestMapping("demo9/{name}/{age}")
    public String demo9(@PathVariable String name,@PathVariable int age){
        System.out.println(name+age);
        return "main";
    }

    @RequestMapping(value = "demo10/{name}/{age}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map demo10(@PathVariable String name,@PathVariable int age){
        System.out.println(name+age);
        Map map = new HashMap();
        map.put("姓名",name);
        map.put("年龄",age);
        People people = new People();
        people.setName(name);
        people.setAge(age);
        map.put("人",people);
        return map;

    }


}
