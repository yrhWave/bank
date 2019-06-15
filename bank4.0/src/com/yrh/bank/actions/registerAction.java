/**
 * Copyright (C), 2018, JXAU
 * FileName: registerAction
 * Author:   YRH
 * Date:     2018/9/3 21:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

import com.yrh.bank.forms.registerActionForm;
import com.yrh.bank.manager.ManagerImpl;
import com.yrh.bank.manager.ManagerInterface;
import com.yrh.bank.util.AppException;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户注册Action〉
 *
 * @author YRH
 * @create 2018/9/3
 * @since 1.0.0
 */
public class registerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        registerActionForm raf = (registerActionForm) form;
        String uname = raf.getUserName();
        String upsd = raf.getUserPassword();

        boolean flag;

        //取得业务层对象

        ManagerInterface manager = ManagerImpl.getManager();
        flag = manager.register(uname, upsd);

        if (flag) {
            //注册成功
            return mapping.findForward("login");
        } else {
            //注册失败
         throw new AppException("error.user.existed");
        }

    }
}