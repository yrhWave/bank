package com.cx.bank.model;
/**
*定义一个MoneyBean类
*@author pingping
*@version 2018.6.11
*/
public class MoneyBean 
{
	private double money;//金额
	private static MoneyBean moneyBean;
	/**
	*设置存款数额
	*@param money
	*return 无
	*/
	public void setMoney(double money){
		this.money=money;
	}


	/**
	*得到存款数额
	*@param 无
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
