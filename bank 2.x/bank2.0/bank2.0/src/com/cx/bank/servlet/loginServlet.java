package com.cx.bank.servlet;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String uname = request.getParameter("uname");
        String upsd = request.getParameter("upsd");

        boolean flag;
        String errorInfo;

        //取得业务层对象
        try {
            ManagerInterface manager = ManagerImpl.getManager();
            flag = manager.login(uname, upsd);

            if (flag) {
                //登录成功
                request.setAttribute("uname",uname);
                session.setAttribute("userName",uname);
                request.getRequestDispatcher("mainFrame.jsp").forward(request, response);
            } else {
                //登录失败
                errorInfo="用户名或密码错误！！";
                request.setAttribute("errorInfo",errorInfo);
                request.getRequestDispatcher("loginError.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
