package com.bjsxt.servlet;

import com.bjsxt.pojo.PageInfo;
import com.bjsxt.service.LogService;
import com.bjsxt.service.impl.LogServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    LogService service = new LogServicesImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int pageSize =Integer.parseInt(req.getParameter("pageSize"));
        //int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        int pageSize = 2;
        int pageNumber = 1;
        String pageSizeStr = req.getParameter("pageSize");
        String pageNumberStr = req.getParameter("pageNumber");
        if(pageSizeStr!=null&&!pageSizeStr.equals("")){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        if(pageNumberStr!=null&&!pageNumberStr.equals("")){
            pageNumber = Integer.parseInt(pageNumberStr);
        }

        PageInfo pi = service.showPage(pageSize,pageNumber);
        req.setAttribute("pageInfo",pi);
        req.getRequestDispatcher("/log.jsp").forward(req,resp);
        //super.service(req, resp);
    }
}
