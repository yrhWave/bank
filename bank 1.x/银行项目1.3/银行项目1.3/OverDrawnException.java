
package com.cx.bank.util;

/**
 *工具包
 *取款超出余额异常
 *@author 6423
 *@version 2018.6.17
 */
public class OverDrawnException extends Exception
{	
	//空的构造函数
	public OverDrawnException()
	{
	}

	////传值给父类Exception属性message
	public OverDrawnException(String name)
	{
		super(name);
	}
} 
 

