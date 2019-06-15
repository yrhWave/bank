
package com.cx.bank.manager;

import  com.cx.bank.model.MoneyBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
/**
 * ҵ���
 * @author YRH
 * @date 2018.6
 * @verson bank v1.0
*/



public class  ManagerImpl implements ManagerInterface

{
	MoneyBean m = MoneyBean.getInstance();
   /**
	 *  ��ѯ����
	 *  @return
	*/

	
	public double inquiry()
	{
		return m.getMoney();
	}


    /**
	 *  ȡ���
	 *  ʵ�֡����㡱���߼��ж�
	 *  @param money
	*/

	public void withdrawals(double money) throws AccountOverDrawnException
	{
		if(money>m.getMoney())
			//����û�ȡ����������׳�AccountOverDrawnException�쳣
		    throw new AccountOverDrawnException("���㣡");
		m.setMoney(m.getMoney()-money);
	}


    /**
	 *  ����
	 *  ʵ�֡�����Ϊ�������߼��ж�
	 *  @param money
	*/

	public void deposit(double money) throws InvalidDepositException
	{
		if(money<=0)
			//����û����Ϊ�������׳�InvalidDepositException�쳣
		    throw new InvalidDepositException("������Ϊ��!");
	    m.setMoney(m.getMoney()+money);

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
