package com.cx.bank.model;


/**
 * �˻����ʵ��Bean �õ���ʵ��--����ģʽ
 * @author YRH
 * @date 2018.6
*/
public class  MoneyBean
{
	private double money;//�˻����

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

//get����
	public void setMoney(double money)
	{
		this.money = money;
	}
	
//set����
	public double getMoney()
	{
		return money;
	}

}
