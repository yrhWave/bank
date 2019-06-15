package com.cx.bank.servlet;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.transferToOneselfException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "transferServlet")
public class transferServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        String errorInfo = "";

        try {
            String zName = request.getParameter("zName");
            double zMoney = Double.parseDouble(request.getParameter("zMoney"));
            boolean flag;
            //取得业务层对象
            ManagerInterface manager = ManagerImpl.getManager();
            flag = manager.transfer(zName, zMoney,userName);

            double balance = manager.inquiry(userName);
            System.out.println(balance);
            request.setAttribute("balance", balance);

            if (flag) {
                request.getRequestDispatcher("balance.jsp").forward(request, response);
            }
        }catch (transferToOneselfException e){
            e.printStackTrace();
            errorInfo="不可以给自己转账哦~";
        }catch (Exception e) {
            e.printStackTrace();
            errorInfo = "转账失败！！请核对收款人是否存在，转账金额是否正确！！";
        }
        request.setAttribute("errorInfo", errorInfo);
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
