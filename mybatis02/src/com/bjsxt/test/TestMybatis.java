package com.bjsxt.test;

import com.bjsxt.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    public static void main(String args[]){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        //查询全部
        session.selectList("com.bjsxt.pojo.People.selAll");

        //通过直接传参数，然后由mapper.xml文件 #{0}的索引去找参数
        People p = session.selectOne("com.bjsxt.pojo.People.selOne",1);
        System.out.println(p);

        //通过传map，再通过mapper中的#{id} #{name}，找到map中键对应的值
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","张三");
        People p2 = session.selectOne("com.bjsxt.pojo.People.selOneByMap",map);
        System.out.println(p2);

        //参数传一个类，用mapper中的${id}，中找到这个类的get和set方法，从而找到这个值
        People p3 = new People();
        p3.setId(2);
        p3.setName("李四");
        People p4 = session.selectOne("com.bjsxt.pojo.People.selOneByPeople",p3);
        System.out.println(p4);

        //分页查询，mapper分号后，占位符?不能进行运算，建议把算好的值再传，
        /**
         * 分页查询
         * pageSize 一页的个数
         * pageNumer 页数
         * pageStart表示从表里的第几个开始算
         * pgeStart = pageSize*(pageNumber-1)
         */
        int pageSize = 2;
        int pageNumer = 3;
        int pageStart = pageSize*(pageNumer-1);
        Map<String,Object> map1 = new HashMap<>();
        map1.put("pageStart",pageStart);
        map1.put("pageSize",pageSize);
        List<People> list = session.selectList("com.bjsxt.pojo.People.selPage",map1);
        System.out.println(list);
        session.close();


    }
}
