package com.bjsxt.pojo;

public class PeopleStaticFactory {
    public static People newInstance(){
        System.out.println("静态工厂");
        return new People(2,"静态工厂");
    }
}
