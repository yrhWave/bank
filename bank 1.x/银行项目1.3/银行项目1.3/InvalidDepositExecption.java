
package com.cx.bank.util;

/**
 *工具包
 *定义存款为负数抛出异常类
 *@author 6423
 *@version 2018.6.17
 */

public class InvalidDepositExecption extends Exception  
{
	//空的构造函数
	public InvalidDepositExecption(){
	}
	
	//传值给父类Exception属性message
	public InvalidDepositExecption(String name)
	{
		super(name);
	}

}
