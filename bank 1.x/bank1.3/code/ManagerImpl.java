
package com.cx.bank.manager;

import com.cx.bank.model.*;
import com.cx.bank.util.*;
import java.util.Properties;
import  java.io.IOException;
import java.util.Scanner;
import com.cx.bank.dao.*;
/**
 * 业务层
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
	 * 用户注册
	 * @param userName 用户名
	 * @param password 密码
	 * @return boolean
	 * @throws IOException
	 */
	 public boolean register(String userName,String password)throws IOException
	{
		 boolean flag = b.register(userName,password);
		 return flag;
	 }


	 /**
	 * 用户登录
	 * @param userName 用户名
	 * @param password 密码
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
	  * 账户转账
	  * @param name 转入用户名
	  * @param double 转账金额
	  * @return boolean
	  * @throws IOException
	  */
	public  boolean transfer(String name)throws IOException
	{
		boolean flag=b.transfer(name);
		return flag;//b.transfer(name);
	  }


   /**
	 *  查询方法
	 *  @return
	*/

	public double inquiry()throws IOException
	{
		m.setMoney(b.getBalance());
		return m.getMoney();
	}


    /**
	 *  取款方法
	 *  实现“余额不足”的逻辑判断
	 *  @param money
	*/

	public void withdrawals(double money) throws AccountOverDrawnException,IOException
	{
		if(b.getBalance()<money || money < 0)
			//如果用户取款金额大于余额，抛出AccountOverDrawnException异常
		    throw new AccountOverDrawnException("请输入正确取款金额！");	
		b.saveMoney(b.getBalance() - money);
	}


    /**
	 *  存款方法
	 *  实现“存款不能为负”的逻辑判断
	 *  @param money
	*/

	public void deposit(double money) throws InvalidDepositException,IOException
	{
		if(money<=0)
			//如果用户存款为负数，抛出InvalidDepositException异常
		    throw new InvalidDepositException("存款金额不能为负!");
	    b.saveMoney(b.getBalance() + money);

	}

	/**
	 *  退出系统
	*/
    public void exitSystem()
	{
		System.out.println("系统已退出！");
		System.exit(1);
	}

}
