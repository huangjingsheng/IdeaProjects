package com.bjsxt.test;

public class Demo {
    public void print(){
        System.out.println("执行第一个");
    }
    public String print1(){
        System.out.println("执行第二个");
        return "执行第二个返回";
    }
    public void print3(){
        System.out.println("执行第三个");
    }
    public void print4() throws Exception{
        int i = 5/0;
        System.out.println("执行第四个");
    }

    public void print(String name,int id){
        System.out.println("名称：" + name + "id: " + id);
    }

    public void print(String name){
        System.out.println("名称："+ name);

    }
}
