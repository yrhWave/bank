
package com.cx.bank.test;

import com.cx.bank.model.*;
import com.cx.bank.manager.*;
import java.util.*;

/**
 * ���Բ� ������ �û������Լ�����ҵ����ģ�Ͳ���������ҵ��
 * @author YRH
 * @date 2018.6
 * @verson bank v1.0
*/


public class TestBank 
{
	public static void printMaue()
	{
		System.out.println("--------------------����ϵͳ1.0--------------------");
	    System.out.println("                    1����ѯ���");
	    System.out.println("                    2����    ��");
	    System.out.println("                    3��ȡ    ��");
	    System.out.println("                    4���˳�ϵͳ");
		System.out.println("-----------------------------------------------------");
	}
	
	public static void main(String[] args) 
	{
		printMaue();
		ManagerImpi manager = new ManagerImpi();//ȡ��ҵ������
		Scanner scanner = new Scanner(System.in);
		String flag = null;

		while(true)
		{
			System.out.println("��������Ĳ�����");
			flag = scanner.next();
			if("1".equals(flag))//��ѯ����
			{
				System.out.println("����ǰ���Ϊ��"+manager.inquiry()+"");
			}else if("2".equals(flag))//������
			{
					System.out.println("���������");
					double money = scanner.nextDouble();
					boolean flag1 = manager.deposit(money);
					if(flag1==false)
				    {
						printMaue();
						continue;
					}
					System.out.println("���ɹ�����ǰ��"+manager.inquiry()+"");
			}else if ("3".equals(flag))//ȡ�����
			{
				System.out.println("�����ȡ���");
					double money = scanner.nextDouble();
					boolean flag2 = manager.withdrawals(money);
					if(flag2==false)
				    {
						printMaue();
						continue;
					}
					System.out.println("ȡ��ɹ�����ǰ��"+manager.inquiry()+"");
			}else if ("4".equals(flag))
			{
				System.out.println("���˳�����ϵͳ����ӭ�´ι��٣�");
				manager.exitSystem();
			}else
			{
				System.out.println("��������ȷ������");
			}
		}
	}
}
