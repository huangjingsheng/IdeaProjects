package com.bjsxt.service.impl;

import com.bjsxt.pojo.Log;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.LogService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServicesImpl implements LogService {

    @Override
    public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",pageSize*(pageNumber-1));
        map.put("pageSize",pageSize);
        List<Log> list = session.selectList("com.bjsxt.mapper.LogMapper.selByPage",map);
        long count = session.selectOne("com.bjsxt.mapper.LogMapper.selCount");
        PageInfo pi = new PageInfo();
        pi.setPageSize(pageSize);
        pi.setPageNumber(pageNumber);
        pi.setList(list);
        pi.setTotal(count%pageSize!=0?count/pageSize+1:count/pageSize);
        return pi;
    }
}
