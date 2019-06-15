package com.cx.bank.servlet;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "inquiryServlet")
public class inquiryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName =(String)session.getAttribute("userName");

        double balance;
        try {
            //取得业务层对象
            ManagerInterface manager = ManagerImpl.getManager();
            balance = manager.inquiry(userName);
            request.setAttribute("balance", balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("balance.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
