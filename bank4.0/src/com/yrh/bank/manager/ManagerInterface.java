
package com.yrh.bank.manager;


import java.io.IOException;
import java.sql.SQLException;

/**
 *  定义一个业务层接口
 *  @data 2018.7
 *  @author YRH
 */

public interface ManagerInterface
{

    /**
     * 用户注册
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    boolean register(String userName, String password)throws IOException,SQLException;


    /**
     * 用户登陆
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    boolean login(String userName, String password)throws IOException,SQLException;


    /**
     * 账户转账
     * @param zName 转入用户名
     * @param zMoney 转账金额
     * @return boolean
     * @throws IOException
     */
    boolean transfer(String zName, double zMoney, String userName)throws IOException,SQLException;


    /**
     * 查询余额
     * @return boolean
     */

    double inquiry(String userName)throws IOException,SQLException;

    /**
     * 取款
     * @param R 取款金额
     * @return boolean

     */

    boolean withdrawals(double R, String userName)throws IOException,SQLException;

    /**
     * 存款
     * @param R 存款金额
     * @return boolean
     */

    boolean deposit(double R, String userName)throws IOException,SQLException;



}