package com.bjsxt.test;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdivce implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("方法："+method);
        System.out.println("参数：" +objects);
        System.out.println("对象：" + o);
        System.out.println("执行前置通知");
    }
}
