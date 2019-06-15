
package com.cx.bank.util;

/**
 * 存款为负数时抛出异常
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
