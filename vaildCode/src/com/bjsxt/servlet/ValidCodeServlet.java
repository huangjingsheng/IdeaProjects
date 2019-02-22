package com.bjsxt.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage image = new BufferedImage(100,50,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,200,100);
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<4;i++){
            list.add(random.nextInt(10));
        }
        graphics.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,40));
        Color[] colors = new Color[]{Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN,Color.PINK,Color.GRAY};
        for(int i=0;i<list.size();i++){
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawString(list.get(i)+"",i*20,30+(random.nextInt((21)-10)));
        }
        for(int i=0;i<2;i++){
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(0,random.nextInt(51),100,random.nextInt(51));
        }
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        ImageIO.write(image,"jpg",servletOutputStream);
        HttpSession session = req.getSession();
        session.setAttribute("code",""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
    }
}
