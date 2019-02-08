package com.bjsxt.service;

import com.bjsxt.pojo.PageInfo;

import java.io.IOException;

public interface LogService {
    PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
