
package com.yrh.bank.dao;


import java.io.IOException;
import java.sql.SQLException;

/**
 * 定义一个持久层接口
 *
 * @author YRH
 * @data 2018.7
 */

public interface BankDaoInterface {
    /**
     * 存储余额
     *
     * @param money
     * @throws IOException
     */
    boolean saveMoney(double money, String userName) throws IOException,SQLException;

    /**
     * 取款
     *
     * @param money
     * @throws IOException
     */
    boolean withDraw(double money, String userName)throws IOException,SQLException;

    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    boolean register(String userName, String password) throws IOException,SQLException;


    /**
     * 用户登陆
     *
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    boolean login(String userName, String password) throws IOException,SQLException;

    /**
     * 获取余额
     *
     * @return double
     * @throws IOException
     */
    double getBalance(String userName) throws IOException,SQLException;

    /**
     * 账户转账
     *
     * @param zName  转账账户名
     * @param zMoney 转账金额
     * @return boolean
     * @Exception throws IOException
     */
    boolean transfer(String zName, double zMoney, String userName) throws IOException,SQLException;

}