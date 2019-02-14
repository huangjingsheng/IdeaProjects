package com.bjsxt.sevice;

import com.bjsxt.pojo.Airplane;

import java.util.List;

public interface AirplaneService {
    List<Airplane> showAirplane(int takeid,int landid);
}
