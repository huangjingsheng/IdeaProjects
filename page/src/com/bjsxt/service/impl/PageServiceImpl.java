package com.bjsxt.service.impl;

import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.PageService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class PageServiceImpl implements PageService {

    @Override
    public PageInfo show(int pageSize, int pageNumber) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        PageInfo pi = new PageInfo();
        pi.setPageSize(pageSize);
        pi.setPageNumber(pageNumber);
        Map<Object,Object> map = new HashMap<>();
        map.put("pageStart",pageSize*(pageNumber-1));
        map.put("pageSize",pageSize);
        pi.setList(session.selectList("com.bjsxt.mapper.PeopleMapper.selPage",map));

        long count = session.selectOne("com.bjsxt.mapper.PeopleMapper.selCount");

        pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);

        return pi;
    }
}
