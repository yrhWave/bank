
package com.cx.bank.manager;

import com.cx.bank.model.*;
import com.cx.bank.util.*;
import java.util.Properties;
import  java.io.IOException;
import java.util.Scanner;
import com.cx.bank.dao.*;
/**
 * ҵ���
 * @author YRH
 * @date 2018.7
 * @verson bank v1.3
*/



public class  ManagerImpl implements ManagerInterface

{
	private static ManagerImpl manager = null;
	MoneyBean m = MoneyBean.getInstance( );
	//BankDaoInterface b=BankDaoImpl.getBankDaoImpl();
	//private BankDaoInterface userDao = null;
	BankDaoInterface b = FileDaoImpl.getInstance( );

	private ManagerImpl( )
	{ 
		//userDaoFactory  DaoFactory = UserDaoFactory.getInstance();
		//DaoFactory.createUserDao();
	  }

	public static ManagerImpl getManager()
	{	
	if (manager==null)
		{
			manager = new ManagerImpl();
		}
		return manager;
	}

	/**
	 * �û�ע��
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	 public boolean register(String userName,String password)throws IOException
	{
		 boolean flag = b.register(userName,password);
		 return flag;
	 }


	 /**
	 * �û���¼
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	 public boolean login(String userName,String password)throws IOException
	{
		 //UserBean user = new UserBean ();
		 //user.setUserName(userName);
		 //user.setPassword(password);
		 boolean flag = b.login(userName,password);
		 return flag;
	 }

	 /**
	  * �˻�ת��
	  * @param name ת���û���
	  * @param double ת�˽��
	  * @return boolean
	  * @throws IOException
	  */
	public  boolean transfer(String name)throws IOException
	{
		boolean flag=b.transfer(name);
		return flag;//b.transfer(name);
	  }


   /**
	 *  ��ѯ����
	 *  @return
	*/

	public double inquiry()throws IOException
	{
		m.setMoney(b.getBalance());
		return m.getMoney();
	}


    /**
	 *  ȡ���
	 *  ʵ�֡����㡱���߼��ж�
	 *  @param money
	*/

	public void withdrawals(double money) throws AccountOverDrawnException,IOException
	{
		if(b.getBalance()<money || money < 0)
			//����û�ȡ����������׳�AccountOverDrawnException�쳣
		    throw new AccountOverDrawnException("��������ȷȡ���");	
		b.saveMoney(b.getBalance() - money);
	}


    /**
	 *  ����
	 *  ʵ�֡�����Ϊ�������߼��ж�
	 *  @param money
	*/

	public void deposit(double money) throws InvalidDepositException,IOException
	{
		if(money<=0)
			//����û����Ϊ�������׳�InvalidDepositException�쳣
		    throw new InvalidDepositException("������Ϊ��!");
	    b.saveMoney(b.getBalance() + money);

	}

	/**
	 *  �˳�ϵͳ
	*/
    public void exitSystem()
	{
		System.out.println("ϵͳ���˳���");
		System.exit(1);
	}

}
