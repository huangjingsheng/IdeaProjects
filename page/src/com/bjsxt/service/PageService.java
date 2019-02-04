package com.bjsxt.service;

import com.bjsxt.pojo.PageInfo;

import java.io.IOException;

public interface PageService {
    /**
     * 分页显示
     * @param pageSize
     * @param pageNumber
     * @return
     */
    PageInfo show(int pageSize,int pageNumber) throws IOException;

}
