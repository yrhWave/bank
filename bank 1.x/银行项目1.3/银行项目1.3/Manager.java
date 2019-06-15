
package com.cx.bank.manager;

import com.cx.bank.util.*;
import java.io.*;

/**
*ҵ���
*����һ���ӿ�
*@author 6423
*@version 2018.6.11
*/
public interface Manager
{
	/**
	*�û�ע��
	*@param String userName �û���
	*@param String passward ����
	*@throws IOException
	*@return boolean
	*/

	boolean register(String userName,String passward)throws IOException;

	/**
	*��ѯ�˻����
	*@param ��
	*@return double
	*/
	double inquiry()throws IOException;

	/**
	*ȡ��
	*@param double
	*@return ��
	*/
	void withdrawals(double flag)throws OverDrawnException,IOException;

	/**
	*���
	*param double
	*return ��
	*/
	void deposit(double flag)throws InvalidDepositExecption,IOException;

	/**
	*�˳�ϵͳ
	*@param ��
	*@return ��
	*/
	void exit();

	/**
	  *�û���¼
	  *@param String userName �û���
	  *@param String password ����
	  *@throws IOException
	  */
	boolean login(String userName,String passward)throws IOException;

	/**
	*�˻�ת��
	*@param String ת���˻���
	*@param double ת�˽��
	*@Exception throws IOException
	*/
	boolean transfer(String name)throws IOException;
} 
