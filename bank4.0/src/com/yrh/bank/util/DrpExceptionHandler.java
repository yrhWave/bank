/**
 * Copyright (C), 2018, JXAU
 * FileName: DrpExceptionHandler
 * Author:   YRH
 * Date:     2018/9/4 20:09
 * Description: 异常类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈异常类〉
 *
 * @author YRH
 * @create 2018/9/4
 * @since 1.0.0
 */

import org.apache.struts.Globals;
import org.apache.struts.action.*;
import org.apache.struts.config.ExceptionConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 个性化异常处理类
 */
public class DrpExceptionHandler extends ExceptionHandler {
    @Override
    public ActionForward execute(
            Exception ex,
            ExceptionConfig ae,
            ActionMapping mapping,
            ActionForm formInstance,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException {

        if (!(ex instanceof AppException )) {
            return super.execute(ex, ae, mapping, formInstance, request, response);
        }

        AppException  errCodeEx =(AppException) ex;
        ActionForward forward = null;
        ActionMessage error = null;
        String property = null;

        // Build the forward from the exception mapping if it exists
        // or from the form input
        if (ae.getPath() != null) {
            forward = new ActionForward(ae.getPath());
        } else {
            forward = mapping.getInputForward();
        }

        //----------处理个性化异常-------------
        AppException ece =(AppException) ex;
        String errorCode =ece.getErrorCode();
        error = new ActionMessage(errorCode, ece.getArgs());
        property = error.getKey();
        //-----------------------------------

        logException(ex);

        // Store the exception
        request.setAttribute(Globals.EXCEPTION_KEY, ex);
        storeException(request, property, error, forward, ae.getScope());

        return forward;
    }

}
