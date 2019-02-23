package com.bjsxt.test;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("返回："+o);
        System.out.println("方法："+method);
        System.out.println("参数：" +objects);
        System.out.println("对象：" + o1);
        System.out.println("执行后置通知");
    }
}
