/**
 * Copyright (C), 2018, JXAU
 * FileName: inquiryAction
 * Author:   YRH
 * Date:     2018/9/5 10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

import com.yrh.bank.manager.ManagerImpl;
import com.yrh.bank.manager.ManagerInterface;
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
public class inquiryAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        double balance;

        //取得业务层对象
        ManagerInterface manager = ManagerImpl.getManager();
        balance = manager.inquiry(userName);
        request.setAttribute("balance", balance);

        return mapping.findForward("inquiry");

    }
}