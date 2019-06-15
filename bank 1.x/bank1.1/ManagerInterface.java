
package com.cx.bank.manager;

import  com.cx.bank.model.*;

/**
 *  ����һ��ҵ���ӿ�
 *  @data 2018.6.15
 *  @author YRH
*/

public interface ManagerInterface
{
	/**
	 *  ��ѯ���
	 *  @return
	*/

	double inquiry();

	/**
	 *  ȡ��
	 *  @param R
	 *  @return
	*/

	boolean withdrawals(double R);

	/**
	 *  ���
	 *  @param R
	*/

	boolean deposit(double R);

	/**
	 *  �˳�ϵͳ
	*/

	void exitSystem();


}