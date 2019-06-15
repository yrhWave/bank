/**
 * Copyright (C), 2018, JXAU
 * FileName: ChangeLanguageAction
 * Author:   YRH
 * Date:     2018/9/4 17:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.actions;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/4
 * @since 1.0.0
 */
public class ChangeLanguageAction extends Action {

    @Override
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
        String lan = request.getParameter("lan");
        Locale currentLocale = null;
        if ("en".equals(lan)) {
            currentLocale = new Locale("en", "US");
        } else if ("zh".equals(lan)) {
            currentLocale = new Locale("zh", "CN");
        }
        request.getSession().setAttribute(Globals.LOCALE_KEY, currentLocale);
        return mapping.findForward("success");
    }
}
