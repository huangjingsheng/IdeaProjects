package com.bjsxt.servlet;

import com.bjsxt.pojo.Log;
import com.bjsxt.service.LogService;
import com.bjsxt.service.impl.LogServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private LogService service = new LogServicesImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Log log = new Log();
        log.setAccin(req.getParameter("accin"));
        log.setAccout(req.getParameter("accout"));
        log.setMoney(Double.parseDouble(req.getParameter("money")));
        Date date =new Date();
        log.setDate(date);
        int index = service.ins(log);
        if(index>0){
            resp.sendRedirect("success.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }
}
