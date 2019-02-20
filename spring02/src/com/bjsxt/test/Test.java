package com.bjsxt.test;

import com.bjsxt.pojo.Airport;
import com.bjsxt.service.impl.AirportServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] arges) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        AirportServiceImpl airportServiceImpl = applicationContext.getBean("airportServiceImpl", AirportServiceImpl.class);
        List<Airport> list = airportServiceImpl.show();
        System.out.println(list);
    }
}
