
package com.cx.bank.manager;

import  com.cx.bank.model.*;
/**
 * ҵ���
 * @author YRH
 * @date 2018.6
 * @verson bank v1.0
*/



public class  ManagerImpl implements ManagerInterface

{
	MoneyBean m = MoneyBean.getInstance();

	//��ѯ����
	
	public double inquiry()
	{
		return m.getMoney();
	}

    //ȡ�����ʵ�֡����㡱���߼��ж�
	
	public boolean withdrawals(double R)
	{
		if(m.getMoney()>=R)
		{
			m.setMoney(m.getMoney()-R);
			return true;
		}else
		{
			System.out.println("���㣡");
		}
			return false;
	}

	//������ʵ�֡�����Ϊ�������߼��ж�
	
	public boolean deposit(double R)
	{
		if(R>=0)
		{
			m.setMoney(m.getMoney()+R);
			return true;
		}else
		{
			System.out.println("������Ϊ����");		
		}
			return false;
	}

	//�˳�ϵͳ
    public void exitSystem()
	{
		System.out.println("ϵͳ���˳���");
		System.exit(1);
	}

}
