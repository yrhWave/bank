
package com.cx.bank.util;

/**
 * ���Ϊ����ʱ�׳��쳣
 * @date 2018.6
 * @author YRH
*/

//@SuppressWarnings("serial")
public class InvalidDepositException extends Exception
{
	public InvalidDepositException(){

		super();

	}

	public InvalidDepositException(String msg){

		super(msg);

	}
}
