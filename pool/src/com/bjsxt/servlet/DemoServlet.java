package com.bjsxt.servlet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/pool")
public class DemoServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/test");
            Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from flower");
            ResultSet rs = ps.executeQuery();
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            while (rs.next()){
                out.println(rs.getInt(1) + rs.getString(2) + "<br/>");
                System.out.println(rs.getInt(1));

                System.out.println(rs.getString(2));
            }
            out.flush();
            out.close();
            rs.close();

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
