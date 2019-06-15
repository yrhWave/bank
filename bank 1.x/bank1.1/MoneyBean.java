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

//get方法
	public void setMoney(double money)
	{
		this.money = money;
	}
	
//set方法
	public double getMoney()
	{
		return money;
	}

}
