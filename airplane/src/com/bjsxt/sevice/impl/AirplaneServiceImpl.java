package com.bjsxt.sevice.impl;

import com.bjsxt.mapper.AirplaneMapper;
import com.bjsxt.pojo.Airplane;
import com.bjsxt.sevice.AirplaneService;
import com.bjsxt.util.MybatisUtil;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {
    @Override
    public List<Airplane> showAirplane(int takeid, int landid) {
        return MybatisUtil.getSession().getMapper(AirplaneMapper.class).sellByTakeIdLandId(takeid,landid);
    }
}
