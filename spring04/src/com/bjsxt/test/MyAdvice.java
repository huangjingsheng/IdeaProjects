package com.bjsxt.test;

public class MyAdvice {
    public void myBefore(String name,int id){
        System.out.println("前置：姓名"+name+" id:"+id);
    }

    public void myBefore1(String name){
        System.out.println("前置：姓名："+name);
    }

    public void myAfter(){
        System.out.println();
    }
}
