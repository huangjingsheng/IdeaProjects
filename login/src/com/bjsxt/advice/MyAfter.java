package com.bjsxt.advice;

import com.bjsxt.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        User user = (User) objects[0];
        Logger logger = Logger.getLogger(MyAfter.class);
        if(user!=null){
            logger.info(user.getUsername()+"登录成功");
        }else {
            logger.info(user.getUsername()+"登录失败");
        }
    }
}
