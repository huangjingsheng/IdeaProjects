package com.bjsxt.test;

import com.bjsxt.mapper.LogMapper;
import com.bjsxt.pojo.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String arges[]) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        LogMapper mapper = session.getMapper(LogMapper.class);
        //List<Log> logs = mapper.selAll();
        /**
         * 参数，mapper通过索引找到值
         */
        //List<Log> logs = mapper.selByAccoutAccin("1", "2");
        /**
         * 动态SQL
         * accout和accin 传 null 或""都可以
         */
        String accout = "1";
        String accin = "2";
        List<Log> logs = mapper.sel(accout,accin);

        for(Log log : logs){
            System.out.println(log);
        }
    }
}