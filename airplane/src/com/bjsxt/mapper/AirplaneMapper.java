package com.bjsxt.mapper;

import com.bjsxt.pojo.Airplane;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirplaneMapper {
    List<Airplane> sellByTakeIdLandId(@Param("takeid") int takeid,@Param("landid") int landid);
}
