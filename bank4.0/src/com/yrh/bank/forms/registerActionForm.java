/**
 * Copyright (C), 2018, JXAU
 * FileName: registerActionForm
 * Author:   YRH
 * Date:     2018/9/3 21:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.forms;

import org.apache.struts.action.ActionForm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/3
 * @since 1.0.0
 */
public class registerActionForm  extends ActionForm {
    /**
     * 用户名
     */

    private String userName;
    /**
     * 密码
     */
    private String userPassword;


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}