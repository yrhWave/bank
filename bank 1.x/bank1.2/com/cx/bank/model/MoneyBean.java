
package com.cx.bank.model;

/**
 * 账户余额实体Bean 用单例实现--饱汉模式
 * @author YRH
 * @date 2018.6
*/

public class  MoneyBean
{
	private double money;//账户余额

	private static MoneyBean instance;

    /**
	 *  无参构造方法
	*/
		private MoneyBean()
	{

	}

	public static MoneyBean getInstance()
	{	
	if (instance==null)
		{
			instance = new MoneyBean();
		}
		return instance;
	}


   /**
	 *  set方法
	 *  @param money
	*/

	public void setMoney(double money)
	{
		this.money = money;
	}
	

    /**
	 *  get方法
	 *  @return
	*/

	public double getMoney()
	{
		return money;
	}

}
