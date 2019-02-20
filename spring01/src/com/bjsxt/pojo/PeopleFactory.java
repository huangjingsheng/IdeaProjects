package com.bjsxt.pojo;

public class PeopleFactory {
    public People newInstance(){
        System.out.println("实例工厂");
        return new People(1,"测试");
    }
}
