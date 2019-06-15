
package com.cx.bank.test;

import java.util.Scanner;
import java.util.InputMismatchException;
import  java.io.IOException;
import  java.io.FileNotFoundException;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;


/**
 * ���Բ� ������ �û������Լ�����ҵ����ģ�Ͳ���������ҵ��
 * @author YRH
 * @date 2018.7.17
 * @verson bank v1.4
*/


public class TestBank 
{
	static String logname = null;
	public static void printMaue1()
	{
	    System.out.println("--------------------����ϵͳ1.4--------------------");
	    System.out.println("                    1��ע    ��");
	    System.out.println("                    2����    ¼");
	    System.out.println("                    3���˳�ϵͳ");
		System.out.println("---------------------��ӭʹ��----------------------");
	}
	public static void printMaue2()
	{
		System.out.println("--------------------����ϵͳ1.4--------------------");
	    System.out.println("                    1����ѯ���");
	    System.out.println("                    2����    ��");
	    System.out.println("                    3��ȡ    ��");
		System.out.println("                    4��ת    ��");
	    System.out.println("                    5���˳�ϵͳ");
		System.out.println("---------------------��ӭʹ��----------------------");
	}
	
	public static void main(String[] args) throws Exception
	{
		printMaue1();
		ManagerInterface manager =ManagerImpl.getManager();//ȡ��ҵ������
		Scanner scanner = new Scanner(System.in);
		String flag = null;
		while(true)
		{
			System.out.println("��ѡ����Ĳ�����");
			flag = scanner.next();
			if("1".equals(flag)){
			    System.out.println("�������û�����");
				String userName = scanner.next();
				System.out.println("���������룺");
				String password = scanner.next();
				try{
				    manager.register(userName,password);
				}catch (IOException e){
				    System.out.println(e.getMessage());
					}
				printMaue1();
				continue;
			}else if("2".equals(flag)){
			    System.out.println("�������û�����");
				String userName = scanner.next();
				System.out.println("���������룺");
				String password = scanner.next();
				boolean b= true;
				try{
				   b=manager.login(userName,password);
					}catch (IOException e){
					    System.out.println(e.getMessage());
						}
						if(b==true)
							break;
						else
							continue;
			}else if("3".equals(flag)){
				System.out.println("���˳�����ϵͳ����ӭ�´ι��٣�");
				manager.exitSystem();
		}else{
			System.out.println("��������ȷ������");
		}
		}

		printMaue2();
		String flag1 = null;
		while(true)
		{
			System.out.println("��������Ĳ�����");
			flag1 = scanner.next();
			if("1".equals(flag1))//��ѯ����
			{
				try{
					System.out.println("����ǰ���Ϊ��"+manager.inquiry()+"");
				}catch(FileNotFoundException e){
				    System.out.println(e.getMessage());
					}catch(IOException e){
				    System.out.println(e.getMessage());
				}
			}else if("2".equals(flag1))//������
			{
					System.out.println("���������");
					double money = scanner.nextDouble();
					try{
						    manager.deposit(money);
						    System.out.println("���ɹ�����ǰ��"+manager.inquiry()+"");
						}catch(InvalidDepositException e){
							System.out.println(e.getMessage ( ));
							//System.out.println("������Ϊ�����������������");
							
						}catch (InputMismatchException e)//�����������Ͳ�ƥ��򳬳����ͷ�Χ�쳣
				{
					System.out.println("�������Ͳ�ƥ����߳������ͷ�Χ��");//��ʾ�쳣��Ϣ
				}catch(IOException e){
				    System.out.println(e.getMessage());
				}
				printMaue2();
				continue;
			}else if ("3".equals(flag1))//ȡ�����
			{
				System.out.println("�����ȡ���");
					try{
					        double money = scanner.nextDouble();
				            manager.withdrawals(money);
				            System.out.println("ȡ��ɹ�����ǰ��"+manager.inquiry()+"");
					    }catch(AccountOverDrawnException e){
					        System.out.println(e.getMessage ( ));
					        //System.out.println("���㣬����������ȡ����");
					}catch (InputMismatchException e)//�����������Ͳ�ƥ��򳬳����ͷ�Χ�쳣
				{
					System.out.println("�������Ͳ�ƥ����߳������ͷ�Χ��");//��ʾ�쳣��Ϣ
				}catch(IOException e){
				    System.out.println(e.getMessage());
				}
				 printMaue2();
				 continue;
			}else if("4".equals(flag1)){
							System.out.println("������ת���˻�����");
							String name = scanner.next();
							try{
							    manager.transfer(name);
								}catch (InputMismatchException e)//�����������Ͳ�ƥ��򳬳����ͷ�Χ�쳣
				{
					System.out.println("�������Ͳ�ƥ����߳������ͷ�Χ��");//��ʾ�쳣��Ϣ
				}catch(IOException e){
				    System.out.println(e.getMessage());
				}
				 printMaue2();
				 continue;
						}else if ("5".equals(flag1))//�˳�ϵͳ
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
