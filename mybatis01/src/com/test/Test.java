package com.test;

import com.bjsxt.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args){

        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用工厂设计模式
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = factory.openSession();
        List<Flower> list = session.selectList("a.b.selAll");

        for(Flower flower : list){
            System.out.println(flower.toString());
        }
        session.close();
    }
}
