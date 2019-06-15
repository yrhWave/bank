/**
 * Copyright (C), 2018, JXAU
 * FileName: loginAction
 * Author:   YRH
 * Date:     2018/9/3 20:17
 * Description: 用户登录Action
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

import com.yrh.bank.forms.loginActionForm;
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
 * 〈用户登录Action〉
 *
 * @author YRH
 * @create 2018/9/3
 * @since 1.0.0
 */
public class loginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession session = request.getSession();

        loginActionForm laf = (loginActionForm) form;
        String uname = laf.getUserName();
        String upsd = laf.getUserPassword();

        boolean flag;
        //取得业务层对象
        ManagerInterface manager = ManagerImpl.getManager();
        flag = manager.login(uname, upsd);

        if (flag) {
            //登录成功
            request.setAttribute("uname", uname);
            session.setAttribute("userName", uname);
            return mapping.findForward("success");
        } else {

            throw new AppException("error.user.password");
        }

    }
}

