
package com.cx.bank.test;

import com.cx.bank.model.*;
import com.cx.bank.manager.*;
import java.util.*;

/**
 * 测试层 主方法 用户界面以及调用业务层和模型层来完成相关业务
 * @author YRH
 * @date 2018.6
 * @verson bank v1.0
*/


public class TestBank 
{
	public static void printMaue()
	{
		System.out.println("--------------------银行系统1.0--------------------");
	    System.out.println("                    1、查询余额");
	    System.out.println("                    2、存    款");
	    System.out.println("                    3、取    款");
	    System.out.println("                    4、退出系统");
		System.out.println("-----------------------------------------------------");
	}
	
	public static void main(String[] args) 
	{
		printMaue();
		ManagerImpi manager = new ManagerImpi();//取得业务层对象
		Scanner scanner = new Scanner(System.in);
		String flag = null;

		while(true)
		{
			System.out.println("请输入你的操作：");
			flag = scanner.next();
			if("1".equals(flag))//查询操作
			{
				System.out.println("您当前余额为："+manager.inquiry()+"");
			}else if("2".equals(flag))//存款操作
			{
					System.out.println("请输出存款金额：");
					double money = scanner.nextDouble();
					boolean flag1 = manager.deposit(money);
					if(flag1==false)
				    {
						printMaue();
						continue;
					}
					System.out.println("存款成功，当前余额："+manager.inquiry()+"");
			}else if ("3".equals(flag))//取款操作
			{
				System.out.println("请输出取款金额：");
					double money = scanner.nextDouble();
					boolean flag2 = manager.withdrawals(money);
					if(flag2==false)
				    {
						printMaue();
						continue;
					}
					System.out.println("取款成功，当前余额："+manager.inquiry()+"");
			}else if ("4".equals(flag))
			{
				System.out.println("已退出银行系统，欢迎下次光临！");
				manager.exitSystem();
			}else
			{
				System.out.println("请输入正确操作！");
			}
		}
	}
}
