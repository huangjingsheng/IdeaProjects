package com.bjsxt.test;

import org.apache.log4j.Logger;

public class TestLog4j {
    public static void main(String[] args){
        Logger logger = Logger.getLogger(TestLog4j.class);
        logger.debug("这是一个调试信息");
        logger.error("这是一个错误信息");
    }

}
