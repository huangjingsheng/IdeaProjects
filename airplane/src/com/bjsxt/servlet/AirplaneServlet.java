package com.bjsxt.servlet;

import com.bjsxt.pojo.Airplane;
import com.bjsxt.sevice.AirplaneService;
import com.bjsxt.sevice.impl.AirplaneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/aitplaneList")
public class AirplaneServlet extends HttpServlet {
    private AirplaneService service = new AirplaneServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int takeid = 0;
        int landid = 0;
        String takeidStr = req.getParameter("takeid");
        if(takeidStr!=null&&!takeidStr.equals("")){
            takeid = Integer.parseInt(takeidStr);
        }

        String landStr = req.getParameter("landid");
        if(landStr!=null&&!landStr.equals("")){
            landid = Integer.parseInt(landStr);
        }

        List<Airplane> list = service.showAirplane(takeid,landid);
        req.setAttribute("airplaneList",list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
