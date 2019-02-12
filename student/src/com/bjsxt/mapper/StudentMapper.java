package com.bjsxt.mapper;

import com.bjsxt.pojo.PageInfo;
import com.bjsxt.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selByPage(PageInfo pi);

    long selCountStudent(PageInfo pi);
}
