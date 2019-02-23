package com.bjsxt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String arges[]) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo = ac.getBean("demo", Demo.class);
        try {
            demo.print("张三",1);
            demo.print("李四");
        } catch (Exception e) {

        }


    }
}
