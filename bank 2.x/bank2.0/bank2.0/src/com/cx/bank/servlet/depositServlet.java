package com.cx.bank.servlet;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.InvalidDepositException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "depositServlet")
public class depositServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        String errorInfo = "";

        try {
            double money = Double.parseDouble(request.getParameter("money"));
            boolean flag;
            //取得业务层对象
            ManagerInterface manager = ManagerImpl.getManager();
            flag = manager.deposit(money,userName);
            double balance = manager.inquiry(userName);
            request.setAttribute("balance", balance);

            if (flag) {
                request.getRequestDispatcher("balance.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (InvalidDepositException e) {
            e.printStackTrace();
            errorInfo = "存款金额不能为负";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            errorInfo = "请输入正确的存款金额！！";
        } catch (IOException e) {
            e.printStackTrace();
            errorInfo = "请输入正确的存款金额！！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("errorInfo", errorInfo);
        request.getRequestDispatcher("error.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
