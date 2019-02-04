package com.bjsxt.servlet;

import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.PageService;
import com.bjsxt.service.impl.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/show")
public class PageShowServlet extends HttpServlet {
    private PageService pageService = new PageServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize = 2;
        String pageSizeStr = req.getParameter("pageSize");
        if(pageSizeStr!=null&&!pageSizeStr.equals("")){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        int pageNumber = 1;
        String pageNumberStr = req.getParameter("pageNumber");
        if(pageNumberStr!=null&&!pageNumberStr.equals("")){
            pageNumber = Integer.parseInt(pageNumberStr);
        }

        PageInfo pi = pageService.show(pageSize,pageNumber);
        req.setAttribute("PageInfo",pi);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
