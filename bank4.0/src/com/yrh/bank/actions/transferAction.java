/**
 * Copyright (C), 2018, JXAU
 * FileName: transferAction
 * Author:   YRH
 * Date:     2018/9/5 20:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

import com.yrh.bank.manager.ManagerImpl;
import com.yrh.bank.manager.ManagerInterface;
import com.yrh.bank.util.AppException;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/5
 * @since 1.0.0
 */
public class transferAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");

        String temp = request.getParameter("zMoney");
        //判断字符串是否为数字
        if (!(temp.matches("[0-9]+"))) {
            throw new AppException("error.transfer.money.format");
        }
        String zName = request.getParameter("zName");
        double zMoney = Double.parseDouble(temp);
        //取得业务层对象
        ManagerInterface manager = ManagerImpl.getManager();
        boolean flag = manager.transfer(zName, zMoney, userName);

        double balance = manager.inquiry(userName);
        System.out.println(balance);
        request.setAttribute("balance", balance);

        if (flag) {
           return mapping.findForward("success");
        }

        return mapping.findForward("error");
    }

}