
package com.cx.bank.manager;

import  com.cx.bank.model.*;
/**
 * 业务层
 * @author YRH
 * @date 2018.6
 * @verson bank v1.0
*/



public class  ManagerImpl implements ManagerInterface

{
	MoneyBean m = MoneyBean.getInstance();

	//查询方法
	
	public double inquiry()
	{
		return m.getMoney();
	}

    //取款方法，实现“余额不足”的逻辑判断
	
	public boolean withdrawals(double R)
	{
		if(m.getMoney()>=R)
		{
			m.setMoney(m.getMoney()-R);
			return true;
		}else
		{
			System.out.println("余额不足！");
		}
			return false;
	}

	//存款方法，实现“存款不能为负”的逻辑判断
	
	public boolean deposit(double R)
	{
		if(R>=0)
		{
			m.setMoney(m.getMoney()+R);
			return true;
		}else
		{
			System.out.println("存款金额不能为负！");		
		}
			return false;
	}

	//退出系统
    public void exitSystem()
	{
		System.out.println("系统已退出！");
		System.exit(1);
	}

}
