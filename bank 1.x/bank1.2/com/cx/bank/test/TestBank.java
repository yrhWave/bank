
package com.cx.bank.test;

import java.util.Scanner;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;
import java.util.InputMismatchException;

/**
 * 测试层 主方法 用户界面以及调用业务层和模型层来完成相关业务
 * @author YRH
 * @date 2018.6.15
 * @verson bank v1.2
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
		ManagerInterface manager = new ManagerImpl();//取得业务层对象
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
					try{
						    manager.deposit(money);
						    System.out.println("存款成功，当前余额："+manager.inquiry()+"");
						}catch(InvalidDepositException e){
							System.out.println(e.getMessage ( ));
							//System.out.println("存款金额不能为负，请重新输入存款金额！");
							printMaue();
							continue;
						}/*catch(InputMismatchException e){
						    System.out.println("请输入正确字符！");
							continue;
						}*/
			}else if ("3".equals(flag))//取款操作
			{
				System.out.println("请输出取款金额：");
					try{
					        double money = scanner.nextDouble();
				            manager.withdrawals(money);
				            System.out.println("取款成功，当前余额："+manager.inquiry()+"");
					    }catch(AccountOverDrawnException e){
					        System.out.println(e.getMessage ( ));
					        //System.out.println("余额不足，请重新输入取款金额");
					        printMaue();
							continue;
					}/*catch(InputMismatchException e){
						    System.out.println("请输入正确字符！");
							continue;
						}*/	
			}else if ("4".equals(flag))//退出系统
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
