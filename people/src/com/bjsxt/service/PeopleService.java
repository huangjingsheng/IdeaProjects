package com.bjsxt.service;

import com.bjsxt.pojo.People;

import java.util.List;

public interface PeopleService {
    /**
     * 显示全部用户
     * @return
     */
    List<People> show();
}
