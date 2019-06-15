
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
 * 测试层 主方法 用户界面以及调用业务层和模型层来完成相关业务
 * @author YRH
 * @date 2018.7.17
 * @verson bank v1.4
*/


public class TestBank 
{
	static String logname = null;
	public static void printMaue1()
	{
	    System.out.println("--------------------银行系统1.4--------------------");
	    System.out.println("                    1、注    册");
	    System.out.println("                    2、登    录");
	    System.out.println("                    3、退出系统");
		System.out.println("---------------------欢迎使用----------------------");
	}
	public static void printMaue2()
	{
		System.out.println("--------------------银行系统1.4--------------------");
	    System.out.println("                    1、查询余额");
	    System.out.println("                    2、存    款");
	    System.out.println("                    3、取    款");
		System.out.println("                    4、转    账");
	    System.out.println("                    5、退出系统");
		System.out.println("---------------------欢迎使用----------------------");
	}
	
	public static void main(String[] args) throws Exception
	{
		printMaue1();
		ManagerInterface manager =ManagerImpl.getManager();//取得业务层对象
		Scanner scanner = new Scanner(System.in);
		String flag = null;
		while(true)
		{
			System.out.println("请选择你的操作：");
			flag = scanner.next();
			if("1".equals(flag)){
			    System.out.println("请输入用户名：");
				String userName = scanner.next();
				System.out.println("请输入密码：");
				String password = scanner.next();
				try{
				    manager.register(userName,password);
				}catch (IOException e){
				    System.out.println(e.getMessage());
					}
				printMaue1();
				continue;
			}else if("2".equals(flag)){
			    System.out.println("请输入用户名：");
				String userName = scanner.next();
				System.out.println("请输入密码：");
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
				System.out.println("已退出银行系统，欢迎下次光临！");
				manager.exitSystem();
		}else{
			System.out.println("请输入正确操作！");
		}
		}

		printMaue2();
		String flag1 = null;
		while(true)
		{
			System.out.println("请输入你的操作：");
			flag1 = scanner.next();
			if("1".equals(flag1))//查询操作
			{
				try{
					System.out.println("您当前余额为："+manager.inquiry()+"");
				}catch(FileNotFoundException e){
				    System.out.println(e.getMessage());
					}catch(IOException e){
				    System.out.println(e.getMessage());
				}
			}else if("2".equals(flag1))//存款操作
			{
					System.out.println("请输出存款金额：");
					double money = scanner.nextDouble();
					try{
						    manager.deposit(money);
						    System.out.println("存款成功，当前余额："+manager.inquiry()+"");
						}catch(InvalidDepositException e){
							System.out.println(e.getMessage ( ));
							//System.out.println("存款金额不能为负，请重新输入存款金额！");
							
						}catch (InputMismatchException e)//捕获输入类型不匹配或超出类型范围异常
				{
					System.out.println("输入类型不匹配或者超出类型范围！");//显示异常信息
				}catch(IOException e){
				    System.out.println(e.getMessage());
				}
				printMaue2();
				continue;
			}else if ("3".equals(flag1))//取款操作
			{
				System.out.println("请输出取款金额：");
					try{
					        double money = scanner.nextDouble();
				            manager.withdrawals(money);
				            System.out.println("取款成功，当前余额："+manager.inquiry()+"");
					    }catch(AccountOverDrawnException e){
					        System.out.println(e.getMessage ( ));
					        //System.out.println("余额不足，请重新输入取款金额");
					}catch (InputMismatchException e)//捕获输入类型不匹配或超出类型范围异常
				{
					System.out.println("输入类型不匹配或者超出类型范围！");//显示异常信息
				}catch(IOException e){
				    System.out.println(e.getMessage());
				}
				 printMaue2();
				 continue;
			}else if("4".equals(flag1)){
							System.out.println("请输入转入账户名：");
							String name = scanner.next();
							try{
							    manager.transfer(name);
								}catch (InputMismatchException e)//捕获输入类型不匹配或超出类型范围异常
				{
					System.out.println("输入类型不匹配或者超出类型范围！");//显示异常信息
				}catch(IOException e){
				    System.out.println(e.getMessage());
				}
				 printMaue2();
				 continue;
						}else if ("5".equals(flag1))//退出系统
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
