
package com.cx.bank.manager;

import com.cx.bank.util.*;
import java.io.*;

/**
*业务层
*定义一个接口
*@author 6423
*@version 2018.6.11
*/
public interface Manager
{
	/**
	*用户注册
	*@param String userName 用户名
	*@param String passward 密码
	*@throws IOException
	*@return boolean
	*/

	boolean register(String userName,String passward)throws IOException;

	/**
	*查询账户余额
	*@param 无
	*@return double
	*/
	double inquiry()throws IOException;

	/**
	*取款
	*@param double
	*@return 无
	*/
	void withdrawals(double flag)throws OverDrawnException,IOException;

	/**
	*存款
	*param double
	*return 无
	*/
	void deposit(double flag)throws InvalidDepositExecption,IOException;

	/**
	*退出系统
	*@param 无
	*@return 无
	*/
	void exit();

	/**
	  *用户登录
	  *@param String userName 用户名
	  *@param String password 密码
	  *@throws IOException
	  */
	boolean login(String userName,String passward)throws IOException;

	/**
	*账户转账
	*@param String 转账账户名
	*@param double 转账金额
	*@Exception throws IOException
	*/
	boolean transfer(String name)throws IOException;
} 
