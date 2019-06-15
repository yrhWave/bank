
package com.cx.bank.manager;

import com.cx.bank.model.*;
import com.cx.bank.util.*;
import java.util.Properties;
import java.io.*;
import java.util.Scanner;
import com.cx.bank.dao.*;



/**
*ҵ���
*����һ��Managerlmpl��ʵ��Manager�ӿ�
*@author 6423
*@version 2018.6.14
*/
public class ManagerImpl implements Manager
{
	private MoneyBean s=MoneyBean.getMoneyBean();
	private BankDaoInterface b=BankDaoImpl.getBankDaoImpl();
  
  
  /**
	*�û�ע��
	*@param String userName �û���
	*@param String passward ����
	*@throws IOException
	*@return boolean
	*/

	public boolean register(String userName,String password)throws IOException{
		boolean buer=b.register(userName,password);
		return buer;//b.register(userName,password);

	}
	/**
	  *�û���¼
	  *@param String userName �û���
	  *@param String password ����
	  *@throws IOException
	  */
	  public boolean login(String userName,String password)throws IOException{
		 boolean buer=b.login(userName,password);
		 return buer;//b.login(userName,password);
	  }
  /**
	*��ѯ�˻����
	*@param ��
	*@return double
	*/
	public double inquiry()throws IOException{
		s.setMoney(b.getBalance());
		return s.getMoney();
	}


  /**
	*ȡ��
	*@param double
	*return ��
	*/
	public void withdrawals(double flag)throws OverDrawnException,IOException{
		if(b.getBalance()<flag)//�ж�����Ƿ����ȡ����
			throw new OverDrawnException("����");//�׳�ȡ�������쳣
		else
		 b.saveMoney(b.getBalance()-flag);

	}


	/**
	*���
	*param double
	*return double
	*/
	public void deposit(double flag)throws InvalidDepositExecption,IOException
	{
		if(flag<0)//�жϴ�������Ƿ�Ϊ����
			throw new InvalidDepositExecption("����Ϊ��");
		else
		b.saveMoney(b.getBalance()+flag);
	}
	/**
	*�˻�ת��
	*@param String ת���˻���
	*@param double ת�˽��
	*@Exception throws IOException
	*/
	public boolean transfer(String name)throws IOException{
		boolean buer=b.transfer(name);
		return buer;//b.transfer(name);
	}
	/**
	*�˳�ϵͳ
	*@param ��
	*@return ��
	*/
	public void exit(){
		System.out.println("�˳�ϵͳ");
		System.exit(1);
	}
}
