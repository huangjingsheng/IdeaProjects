package com.bjsxt.text;

import com.bjsxt.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = ac.getBean("stu", Student.class);
        System.out.println(stu.toString());
    }
}
