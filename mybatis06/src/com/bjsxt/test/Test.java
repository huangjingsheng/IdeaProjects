package com.bjsxt.test;

import com.bjsxt.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String [] ages){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = factory.openSession();
            List<Teacher> list = session.selectList("com.bjsxt.mapper.TeacherMapper.selAll2");

            for(Teacher teacher :list){
                System.out.println(teacher);
            }

            session.close();
            System.out.println("程序执行结束");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
