
package com.cx.bank.manager;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
import  com.cx.bank.model.*;

/**
 *  定义一个业务层接口
 *  @data 2018.6.15
 *  @author YRH
*/

public interface ManagerInterface
{
	/**
	 *  查询余额
	 *  @return
	*/

	double inquiry();

	/**
	 *  取款
	 *  @param R
	 *  @return
	*/

    void withdrawals(double R)throws AccountOverDrawnException;

	/**
	 *  存款
	 *  @param R
	*/

	void deposit(double R)throws InvalidDepositException;

	/**
	 *  退出系统
	*/

	void exitSystem();


}