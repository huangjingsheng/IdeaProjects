package com.bjsxt.service.impl;

import com.bjsxt.mapper.StudentMapper;
import com.bjsxt.mapper.TeacherMapper;
import com.bjsxt.pojo.PageInfo;
import com.bjsxt.pojo.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
        PageInfo pi = new PageInfo();

        int pageSize = 2;
        if(pageSizeStr!=null&&!pageSizeStr.equals("")){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        int pageNumber = 1;
        if(pageNumberStr!=null&&!pageNumberStr.equals("")){
            pageNumber = Integer.parseInt(pageNumberStr);
        }

        pi.setSname(sname);
        pi.setTname(tname);
        pi.setPageSize(pageSize);
        pi.setPageNumber(pageNumber);
        pi.setPageStart((pageNumber-1)*pageSize);

        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.selByPage(pi);
        long count = studentMapper.selCountStudent(pi);
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        for(Student student : list){
            student.setTeacher(teacherMapper.selById(student.getTid()));
        }

        pi.setList(list);
        pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);

        return pi;
    }
}
