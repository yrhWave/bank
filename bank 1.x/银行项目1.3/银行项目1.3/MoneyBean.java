package com.cx.bank.model;
/**
*����һ��MoneyBean��
*@author pingping
*@version 2018.6.11
*/
public class MoneyBean 
{
	private double money;//���
	private static MoneyBean moneyBean;
	/**
	*���ô������
	*@param money
	*return ��
	*/
	public void setMoney(double money){
		this.money=money;
	}


	/**
	*�õ��������
	*@param ��
	*@return double
	*/
	public double getMoney(){
		return this.money;
	}
	public static MoneyBean getMoneyBean(){
		if(moneyBean==null)
			moneyBean=new MoneyBean();
		return moneyBean;
	}
}
