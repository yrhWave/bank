package com.cx.bank.test;

import java.util.InputMismatchException;
import com.cx.bank.model.*;
import com.cx.bank.manager.*;
import com.cx.bank.util.*;
import java.util.Scanner;
import java.util.Properties;
import java.io.IOException;

/**
  *���Բ�
  *@author 6423
  *@version 2018.6.12
  */
public class TestBank{
	public static void service0(){
		System.out.println("**************************");
		System.out.println("*--------��¼����--------*");
		System.out.println("*---------1.ע��---------*");
		System.out.println("*---------2.��¼---------*");
		System.out.println("*--------3.�˳�ϵͳ------*");
		System.out.println("**************************");
	}
	public static void service1(){
		System.out.println("**************************");
		System.out.println("*--------�������--------*");
		System.out.println("*-------1.��ѯ���-------*");
		System.out.println("*---------2.ȡ��---------*");
		System.out.println("*---------3.���---------*");
		System.out.println("*---------4.ת��---------*");
		System.out.println("*--------5.�˳�ϵͳ------*");
		System.out.println("**************************");
	}
	public static void main(String[] args) {
	

		Manager s1=new ManagerImpl();
		Scanner in=new Scanner(System.in);
		service0();
		while(true)
		{
			System.out.println("���������ҵ��");
			String j=in.next();
			if(j.equals("1")){
				System.out.println("������ע���û���");
				String userName=in.next();
				System.out.println("������ע������");
				String password=in.next();
				try
				{
					s1.register(userName,password);
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				service0();
				continue;
			}
			if(j.equals("2")){
				System.out.println("�������¼�û���");
				String userName=in.next();
				System.out.println("�������¼����");
				String password=in.next();
				boolean b=true;
				try
				{
					b=s1.login(userName,password);
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				if(b==true)
					break;
				else
				    continue;

			}
			if(j.equals("3"))
			{
				s1.exit();//�˳�ϵͳ	
			}
			else
				System.out.println("�����������������");
		}
		Scanner inner=new Scanner(System.in);
		service1();
		while(true){
			System.out.println("���������ҵ��");
			String i=in.next();
			if(i.equals("1")){
				System.out.print("��");
				try
				{
					System.out.println(s1.inquiry());//����ѯ��ʾ���
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				//System.out.println(s1.inquiry());//����ѯ��ʾ���
				continue;
			}
			if(i.equals("2")){
				System.out.println("������ȡ����");
				try
				{
					double a=inner.nextDouble();//����ȡ����
					s1.withdrawals(a);//����ȡ���
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				catch (InputMismatchException e)//�����������Ͳ�ƥ��򳬳����ͷ�Χ�쳣
				{
					System.out.println("�������Ͳ�ƥ����߳������Ͳ�ƥ��");//��ʾ�쳣��Ϣ
				}
				catch (OverDrawnException e)//����ȡ�������쳣
				{
					System.out.println(e.getMessage());//��ʾ�쳣��Ϣ
				}
				continue;
			}
			 if(i.equals("3")){
				System.out.println("����������");
				try
				{
					double a1=inner.nextDouble();//��������
					s1.deposit(a1);//���ô���
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				catch (InputMismatchException e)//�����������Ͳ�ƥ��򳬳����ͷ�Χ�쳣
				{
					System.out.println("�������Ͳ�ƥ����߳������Ͳ�ƥ��");//��ʾ�쳣��Ϣ
				}
				catch(InvalidDepositExecption e)//������Ϊ�����쳣
				 {
					System.out.println(e.getMessage());//��ʾ�쳣��Ϣ
				 }
				continue;
			}
			if(i.equals("4")){
				System.out.println("������ת���û���");
				String name=in.next();
				try
				{
					s1.transfer(name);
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				catch (InputMismatchException e)//�����������Ͳ�ƥ��򳬳����ͷ�Χ�쳣
				{
					System.out.println("�������Ͳ�ƥ����߳������Ͳ�ƥ��");//��ʾ�쳣��Ϣ
				}
				continue;
				
			}
			if(i.equals("5"))
			{
				s1.exit();//�˳�ϵͳ	
			}
			else
				System.out.println("�����������������");
		}
	}
}
