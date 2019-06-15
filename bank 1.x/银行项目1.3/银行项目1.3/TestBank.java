package com.cx.bank.test;

import java.util.InputMismatchException;
import com.cx.bank.model.*;
import com.cx.bank.manager.*;
import com.cx.bank.util.*;
import java.util.Scanner;
import java.util.Properties;
import java.io.IOException;

/**
  *测试层
  *@author 6423
  *@version 2018.6.12
  */
public class TestBank{
	public static void service0(){
		System.out.println("**************************");
		System.out.println("*--------登录界面--------*");
		System.out.println("*---------1.注册---------*");
		System.out.println("*---------2.登录---------*");
		System.out.println("*--------3.退出系统------*");
		System.out.println("**************************");
	}
	public static void service1(){
		System.out.println("**************************");
		System.out.println("*--------服务界面--------*");
		System.out.println("*-------1.查询余额-------*");
		System.out.println("*---------2.取款---------*");
		System.out.println("*---------3.存款---------*");
		System.out.println("*---------4.转账---------*");
		System.out.println("*--------5.退出系统------*");
		System.out.println("**************************");
	}
	public static void main(String[] args) {
	

		Manager s1=new ManagerImpl();
		Scanner in=new Scanner(System.in);
		service0();
		while(true)
		{
			System.out.println("请输入想办业务");
			String j=in.next();
			if(j.equals("1")){
				System.out.println("请输入注册用户名");
				String userName=in.next();
				System.out.println("请输入注册密码");
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
				System.out.println("请输入登录用户名");
				String userName=in.next();
				System.out.println("请输入登录密码");
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
				s1.exit();//退出系统	
			}
			else
				System.out.println("输入错误请重新输入");
		}
		Scanner inner=new Scanner(System.in);
		service1();
		while(true){
			System.out.println("请输入想办业务");
			String i=in.next();
			if(i.equals("1")){
				System.out.print("余额：");
				try
				{
					System.out.println(s1.inquiry());//余额查询显示余额
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				//System.out.println(s1.inquiry());//余额查询显示余额
				continue;
			}
			if(i.equals("2")){
				System.out.println("请输入取款金额");
				try
				{
					double a=inner.nextDouble();//输入取款金额
					s1.withdrawals(a);//调用取款方法
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				catch (InputMismatchException e)//捕获输入类型不匹配或超出类型范围异常
				{
					System.out.println("输入类型不匹配或者超出类型不匹配");//显示异常信息
				}
				catch (OverDrawnException e)//捕获取款超出余额异常
				{
					System.out.println(e.getMessage());//显示异常信息
				}
				continue;
			}
			 if(i.equals("3")){
				System.out.println("请输入存款金额");
				try
				{
					double a1=inner.nextDouble();//输入存款金额
					s1.deposit(a1);//调用存款方法
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				catch (InputMismatchException e)//捕获输入类型不匹配或超出类型范围异常
				{
					System.out.println("输入类型不匹配或者超出类型不匹配");//显示异常信息
				}
				catch(InvalidDepositExecption e)//捕获存款为负数异常
				 {
					System.out.println(e.getMessage());//显示异常信息
				 }
				continue;
			}
			if(i.equals("4")){
				System.out.println("请输入转账用户名");
				String name=in.next();
				try
				{
					s1.transfer(name);
				}
				catch (IOException e)
				{
					System.out.println(e.getMessage());
				}
				catch (InputMismatchException e)//捕获输入类型不匹配或超出类型范围异常
				{
					System.out.println("输入类型不匹配或者超出类型不匹配");//显示异常信息
				}
				continue;
				
			}
			if(i.equals("5"))
			{
				s1.exit();//退出系统	
			}
			else
				System.out.println("输入错误请重新输入");
		}
	}
}
