package com.bjsxt.servlet;

import com.bjsxt.sevice.AirporeService;
import com.bjsxt.sevice.impl.AirporeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/airportList")
public class AirportServlet extends HttpServlet {
    private AirporeService as = new AirporeServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("airportList",as.showAirport());
        req.getRequestDispatcher("aitplaneList").forward(req,resp);
    }
}
