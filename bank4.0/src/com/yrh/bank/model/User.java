/**
 * Copyright (C), 2018, JXAU
 * FileName: User
 * Author:   YRH
 * Date:     2018/9/13 21:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/13
 * @since 1.0.0
 */
public class User {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;






}