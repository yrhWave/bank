package com.cx.bank.servlet;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvaliWithdrawalException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class withdrawalsServlet extends HttpServlet {
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
            flag = manager.withdrawals(money,userName);

            double balance = manager.inquiry(userName);
            System.out.println(balance);
            request.setAttribute("balance", balance);

            if (flag) {
                request.getRequestDispatcher("balance.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            errorInfo = "请输入正确的取款金额！！！";
        } catch (InvaliWithdrawalException e) {
            e.printStackTrace();
            errorInfo = "取款金额不能为负数！！！";
        } catch (AccountOverDrawnException e) {
            e.printStackTrace();
            errorInfo = "账户余额不足！！！";
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
