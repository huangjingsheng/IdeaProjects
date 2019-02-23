package com.bjsxt.test;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyArround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕-前置通知");
        Object proceed = methodInvocation.proceed();
        System.out.println("环绕-后置通知");

        return proceed;
    }
}
