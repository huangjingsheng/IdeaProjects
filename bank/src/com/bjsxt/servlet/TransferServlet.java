package com.bjsxt.servlet;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;
import com.bjsxt.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    private AccountService service = new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        /**
         * 用accOut对象来储存要转出用户的数据，outMoney为正数，在服务层再处理为扣款金额
         */
        String accOutNo = req.getParameter("accOutNo");
        int password =Integer.parseInt(req.getParameter("password"));
        Double outMoney = Double.parseDouble(req.getParameter("outMoney"));
        Account accOut = new Account();
        accOut.setAccno(accOutNo);
        accOut.setPassword(password);
        accOut.setBalance(outMoney);

        /**
         * 用户accIn来储存要转入用户的数据
         */
        String accInNo = req.getParameter("accInNo");
        String name = req.getParameter("name");
        Account accIn = new Account();
        accIn.setAccno(accInNo);
        accIn.setName(name);
        accIn.setBalance(outMoney);

        int code = service.transfer(accIn,accOut);

        if(code==AccountService.SUCCESS){
            resp.sendRedirect("/bank/log.jsp");
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("code",code);
            resp.sendRedirect("/bank/error/error.jsp");
        }
    }
}
