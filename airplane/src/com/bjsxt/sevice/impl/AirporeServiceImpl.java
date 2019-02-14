package com.bjsxt.sevice.impl;

import com.bjsxt.mapper.AirportMapper;
import com.bjsxt.pojo.Airport;
import com.bjsxt.sevice.AirporeService;
import com.bjsxt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirporeServiceImpl implements AirporeService{
    @Override
    public List<Airport> showAirport() {
        SqlSession session = MybatisUtil.getSession();
        AirportMapper mapper = session.getMapper(AirportMapper.class);
        List<Airport> list = mapper.sellAll();
        return list;
    }
}
