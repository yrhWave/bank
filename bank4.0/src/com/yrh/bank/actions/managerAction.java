/**
 * Copyright (C), 2018, JXAU
 * FileName: managerAction
 * Author:   YRH
 * Date:     2018/9/3 23:02
 * Description: 业务动态bean
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

import com.sun.deploy.net.HttpResponse;
import com.yrh.bank.manager.ManagerImpl;
import com.yrh.bank.manager.ManagerInterface;
import com.yrh.bank.util.AppException;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br>
 * 〈业务动态bean〉
 *
 * @author YRH
 * @create 2018/9/3
 * @since 1.0.0
 */
public class managerAction extends baseAction {

    /**
     * 如果没有传递任何标识参数（如command参数），则默认调用unspecified方法
     */
    @Override
    protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("managerAction=>>unspecified()");
        ActionForward listActionForward = new ActionForward("/login.jsp", true);
        return listActionForward;
    }

    public ActionForward inquiry(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println("asd");
        double balance;

        //取得业务层对象
        ManagerInterface manager = ManagerImpl.getManager();
        balance = manager.inquiry(userName);
        request.setAttribute("balance", balance);

        return mapping.findForward("inquiry");
    }

    public ActionForward deposit(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("ferfref");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");

        String temp = request.getParameter("money");

        //判断字符串是否为数字
        if(!(temp.matches("[0-9]+"))){
            throw new AppException("error.deposit.money.format");
        }

        double money = Double.parseDouble(temp);
        boolean flag;
        //取得业务层对象
        ManagerInterface manager = ManagerImpl.getManager();
        flag = manager.deposit(money, userName);
        double balance = manager.inquiry(userName);
        request.setAttribute("balance", balance);

        if (flag) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("error");
        }

    }
}