package com.bjsxt.service.impl;

import com.bjsxt.pojo.People;
import com.bjsxt.service.PeopleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PeopleServiceImpl implements PeopleService {
    @Override
    public List<People> show() {
        List<People> list = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = factory.openSession();
            list = session.selectList("selAll");
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
