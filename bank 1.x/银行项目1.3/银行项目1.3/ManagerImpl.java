
package com.cx.bank.manager;

import com.cx.bank.model.*;
import com.cx.bank.util.*;
import java.util.Properties;
import java.io.*;
import java.util.Scanner;
import com.cx.bank.dao.*;



/**
*业务层
*定义一个Managerlmpl类实现Manager接口
*@author 6423
*@version 2018.6.14
*/
public class ManagerImpl implements Manager
{
	private MoneyBean s=MoneyBean.getMoneyBean();
	private BankDaoInterface b=BankDaoImpl.getBankDaoImpl();
  
  
  /**
	*用户注册
	*@param String userName 用户名
	*@param String passward 密码
	*@throws IOException
	*@return boolean
	*/

	public boolean register(String userName,String password)throws IOException{
		boolean buer=b.register(userName,password);
		return buer;//b.register(userName,password);

	}
	/**
	  *用户登录
	  *@param String userName 用户名
	  *@param String password 密码
	  *@throws IOException
	  */
	  public boolean login(String userName,String password)throws IOException{
		 boolean buer=b.login(userName,password);
		 return buer;//b.login(userName,password);
	  }
  /**
	*查询账户余额
	*@param 无
	*@return double
	*/
	public double inquiry()throws IOException{
		s.setMoney(b.getBalance());
		return s.getMoney();
	}


  /**
	*取款
	*@param double
	*return 无
	*/
	public void withdrawals(double flag)throws OverDrawnException,IOException{
		if(b.getBalance()<flag)//判断余额是否大于取款金额
			throw new OverDrawnException("余额不足");//抛出取款超出余额异常
		else
		 b.saveMoney(b.getBalance()-flag);

	}


	/**
	*存款
	*param double
	*return double
	*/
	public void deposit(double flag)throws InvalidDepositExecption,IOException
	{
		if(flag<0)//判断存款数额是否为负数
			throw new InvalidDepositExecption("存款不能为负");
		else
		b.saveMoney(b.getBalance()+flag);
	}
	/**
	*账户转账
	*@param String 转账账户名
	*@param double 转账金额
	*@Exception throws IOException
	*/
	public boolean transfer(String name)throws IOException{
		boolean buer=b.transfer(name);
		return buer;//b.transfer(name);
	}
	/**
	*退出系统
	*@param 无
	*@return 无
	*/
	public void exit(){
		System.out.println("退出系统");
		System.exit(1);
	}
}
