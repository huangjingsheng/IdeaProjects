package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = ac.getBean("uerService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String code = req.getParameter("code");
        String sessionCode = req.getSession().getAttribute("code").toString();
        if(code.equals(sessionCode)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1 = userService.selByUserPsw(user);
            if (user1!=null){
                resp.sendRedirect("main.jsp");
            }else {
                req.setAttribute("error","账号或密码不正确");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }

        }else {
            req.setAttribute("error","验证码不正确");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
