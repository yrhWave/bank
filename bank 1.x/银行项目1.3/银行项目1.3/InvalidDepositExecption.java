
package com.cx.bank.util;

/**
 *���߰�
 *������Ϊ�����׳��쳣��
 *@author 6423
 *@version 2018.6.17
 */

public class InvalidDepositExecption extends Exception  
{
	//�յĹ��캯��
	public InvalidDepositExecption(){
	}
	
	//��ֵ������Exception����message
	public InvalidDepositExecption(String name)
	{
		super(name);
	}

}
