
package com.cx.bank.manager;

import  java.io.IOException;
import java.sql.SQLException;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvaliWithdrawalException;
import com.cx.bank.util.InvalidDepositException;
import com.cx.bank.util.transferToOneselfException;

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
    boolean register(String userName,String password)throws IOException,SQLException;


    /**
     * 用户登陆
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    boolean login(String userName,String password)throws IOException,SQLException;


    /**
     * 账户转账
     * @param zName 转入用户名
     * @param zMoney 转账金额
     * @return boolean
     * @throws IOException
     */
    boolean transfer(String zName,double zMoney,String userName )throws IOException,AccountOverDrawnException,SQLException,transferToOneselfException;


    /**
     * 查询余额
     * @return boolean
     */

    double inquiry(String userName)throws IOException,SQLException;

    /**
     * 取款
     * @param R 取款金额
     * @return boolean
     * @throws AccountOverDrawnException
     */

    boolean withdrawals(double R,String userName)throws AccountOverDrawnException,InvaliWithdrawalException,IOException,SQLException;

    /**
     * 存款
     * @param R 存款金额
     * @return boolean
     * @throws InvalidDepositException
     */

    boolean deposit(double R,String userName)throws InvalidDepositException,IOException,SQLException;

    /**
     * 退出系统
     */

    void exitSystem();


}