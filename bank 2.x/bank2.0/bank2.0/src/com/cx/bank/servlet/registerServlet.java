package com.cx.bank.servlet;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String upsd = request.getParameter("upsd");

        boolean flag = false;
        String errorInfo="";

        //取得业务层对象
        try {
            ManagerInterface manager = ManagerImpl.getManager();
            flag = manager.register(uname, upsd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag) {
            System.out.println("注册成功！！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            System.out.println("注册失败！！");
            errorInfo="该用户名已存在！！";
            request.setAttribute("errorInfo",errorInfo);
            request.getRequestDispatcher("loginError.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
