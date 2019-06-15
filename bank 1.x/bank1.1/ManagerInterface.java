
package com.cx.bank.manager;

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

	boolean withdrawals(double R);

	/**
	 *  存款
	 *  @param R
	*/

	boolean deposit(double R);

	/**
	 *  退出系统
	*/

	void exitSystem();


}