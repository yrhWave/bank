
package com.cx.bank.manager;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
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

    void withdrawals(double R)throws AccountOverDrawnException;

	/**
	 *  ���
	 *  @param R
	*/

	void deposit(double R)throws InvalidDepositException;

	/**
	 *  �˳�ϵͳ
	*/

	void exitSystem();


}