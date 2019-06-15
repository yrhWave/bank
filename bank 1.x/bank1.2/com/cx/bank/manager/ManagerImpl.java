
package com.cx.bank.manager;

import  com.cx.bank.model.MoneyBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
/**
 * 业务层
 * @author YRH
 * @date 2018.6
 * @verson bank v1.0
*/



public class  ManagerImpl implements ManagerInterface

{
	MoneyBean m = MoneyBean.getInstance();
   /**
	 *  查询方法
	 *  @return
	*/

	
	public double inquiry()
	{
		return m.getMoney();
	}


    /**
	 *  取款方法
	 *  实现“余额不足”的逻辑判断
	 *  @param money
	*/

	public void withdrawals(double money) throws AccountOverDrawnException
	{
		if(money>m.getMoney())
			//如果用户取款金额大于余额，抛出AccountOverDrawnException异常
		    throw new AccountOverDrawnException("余额不足！");
		m.setMoney(m.getMoney()-money);
	}


    /**
	 *  存款方法
	 *  实现“存款不能为负”的逻辑判断
	 *  @param money
	*/

	public void deposit(double money) throws InvalidDepositException
	{
		if(money<=0)
			//如果用户存款为负数，抛出InvalidDepositException异常
		    throw new InvalidDepositException("存款金额不能为负!");
	    m.setMoney(m.getMoney()+money);

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
