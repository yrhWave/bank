
package com.cx.bank.manager;

import  java.io.IOException;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
import com.cx.bank.model.*;

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
	 boolean register(String userName,String password)throws IOException;


	 /**
	 * 用户登陆
	 * @param userName 用户名
	 * @param password 密码
	 * @return boolean
	 * @throws IOException
	 */
	 boolean login(String userName,String password)throws IOException;


	 /**
	  * 账户转账
	  * @param name 转入用户名
	  * @param double 转账金额
	  * @return boolean
	  * @throws IOException
	  */
	  boolean transfer(String name)throws IOException;


	/**
	 * 查询余额
	 * @return 
	*/

	double inquiry()throws IOException;

	/**
	 * 取款
	 * @param R 取款金额
	 * @return
	 * @throws AccountOverDrawnException
	*/

    void withdrawals(double R)throws AccountOverDrawnException,IOException;

	/**
	 * 存款
	 * @param R 存款金额
	 * @return
	 * @throws InvalidDepositException
	*/

	void deposit(double R)throws InvalidDepositException,IOException;

	/**
	 * 退出系统
	*/

	void exitSystem();


}