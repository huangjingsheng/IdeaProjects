package com.bjsxt.mapper;

import com.bjsxt.pojo.Log;

import java.util.List;

public interface LogMapper {
    List<Log> selAll();

    List<Log> selByAccoutAccin(String accout,String accin);
}
