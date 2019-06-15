
package com.cx.bank.test;

import java.util.Scanner;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
import java.util.InputMismatchException;

/**
 * ���Բ� ������ �û������Լ�����ҵ����ģ�Ͳ���������ҵ��
 * @author YRH
 * @date 2018.6.15
 * @verson bank v1.2
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
		ManagerInterface manager = new ManagerImpl();//ȡ��ҵ������
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
					try{
						    manager.deposit(money);
						    System.out.println("���ɹ�����ǰ��"+manager.inquiry()+"");
						}catch(InvalidDepositException e){
							System.out.println(e.getMessage ( ));
							//System.out.println("������Ϊ�����������������");
							printMaue();
							continue;
						}/*catch(InputMismatchException e){
						    System.out.println("��������ȷ�ַ���");
							continue;
						}*/
			}else if ("3".equals(flag))//ȡ�����
			{
				System.out.println("�����ȡ���");
					try{
					        double money = scanner.nextDouble();
				            manager.withdrawals(money);
				            System.out.println("ȡ��ɹ�����ǰ��"+manager.inquiry()+"");
					    }catch(AccountOverDrawnException e){
					        System.out.println(e.getMessage ( ));
					        //System.out.println("���㣬����������ȡ����");
					        printMaue();
							continue;
					}/*catch(InputMismatchException e){
						    System.out.println("��������ȷ�ַ���");
							continue;
						}*/	
			}else if ("4".equals(flag))//�˳�ϵͳ
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
