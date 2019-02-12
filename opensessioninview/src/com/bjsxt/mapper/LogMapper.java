package com.bjsxt.mapper;

import com.bjsxt.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<Log> selAll();

    List<Log> selByAccoutAccin(String accout, String accin);

    List<Log> sel(@Param("accout") String accout, @Param("accin") String accin);

    int ins(Log log);
}
