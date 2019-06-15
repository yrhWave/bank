/**
 * Copyright (C), 2018, JXAU
 * FileName: AppException
 * Author:   YRH
 * Date:     2018/9/4 20:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/4
 * @since 1.0.0
 */

public class AppException extends RuntimeException {

    private Object[] args;

    private String errorCode;

    public AppException (String errorCode) {
        this.errorCode = errorCode;
    }

    public AppException(String errorCode, String args0) {
        this(errorCode, new Object[]{args0});
    }

    public AppException(String errorCode, Object[] args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
