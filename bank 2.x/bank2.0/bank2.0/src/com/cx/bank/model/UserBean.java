/**
 * Copyright (C), 2018, JXAU
 * FileName: UserBean
 * Author:   YRH
 * Date:     2018/8/20 17:44
 * Description: 用户实体bean，保存用户名密码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户实体bean，保存用户名密码〉
 *
 * @author YRH
 * @create 2018/8/20
 * @since 1.0.0
 */
public class UserBean {


    private String userName;
    private String password;


    public void setUserName(String userName)
    {
        this.userName = userName;
    }


    /**
     *  获取用户名
     *  getUserName方法
     *  @return username
     */

    public String getUserName()
    {
        return this.userName;
    }


    /**
     * 设置密码
     * @setPassword 方法
     * @param password
     */

    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     *  获取密码
     *  getPassword方法
     *  @return Password
     */

    public String getPassword()
    {
        return this.password;
    }

}