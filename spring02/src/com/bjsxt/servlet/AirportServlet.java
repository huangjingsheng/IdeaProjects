package com.bjsxt.servlet;

import com.bjsxt.service.AirportService;
import com.bjsxt.service.impl.AirportServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show")
public class AirportServlet extends HttpServlet {
    private AirportService as;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        as = ac.getBean("airportServiceImpl", AirportServiceImpl.class);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", as.show());
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
