/**
 * Copyright (C), 2018, JXAU
 * FileName: baseAction
 * Author:   YRH
 * Date:     2018/9/3 23:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/3
 * @since 1.0.0
 */

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class baseAction extends DispatchAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (request.getSession().getAttribute("userName") == null) {
            return mapping.findForward("login");
        }
        return super.execute(mapping, form, request, response);

    }
}