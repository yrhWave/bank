
package com.cx.bank.util;

/**
 *���߰�
 *ȡ�������쳣
 *@author 6423
 *@version 2018.6.17
 */
public class OverDrawnException extends Exception
{	
	//�յĹ��캯��
	public OverDrawnException()
	{
	}

	////��ֵ������Exception����message
	public OverDrawnException(String name)
	{
		super(name);
	}
} 
 

