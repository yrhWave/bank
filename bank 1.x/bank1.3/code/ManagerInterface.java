
package com.cx.bank.manager;

import  java.io.IOException;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
import com.cx.bank.model.*;

/**
 *  ����һ��ҵ���ӿ�
 *  @data 2018.7
 *  @author YRH
*/

public interface ManagerInterface
{

	/**
	 * �û�ע��
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	 boolean register(String userName,String password)throws IOException;


	 /**
	 * �û���½
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	 boolean login(String userName,String password)throws IOException;


	 /**
	  * �˻�ת��
	  * @param name ת���û���
	  * @param double ת�˽��
	  * @return boolean
	  * @throws IOException
	  */
	  boolean transfer(String name)throws IOException;


	/**
	 * ��ѯ���
	 * @return 
	*/

	double inquiry()throws IOException;

	/**
	 * ȡ��
	 * @param R ȡ����
	 * @return
	 * @throws AccountOverDrawnException
	*/

    void withdrawals(double R)throws AccountOverDrawnException,IOException;

	/**
	 * ���
	 * @param R �����
	 * @return
	 * @throws InvalidDepositException
	*/

	void deposit(double R)throws InvalidDepositException,IOException;

	/**
	 * �˳�ϵͳ
	*/

	void exitSystem();


}