
package com.cx.bank.util;

/**
 * ȡ������ʱ�׳��쳣
 * @date 2018.6
 * @author YRH
*/

//@SuppressWarnings("serial")
public class AccountOverDrawnException extends Exception
{
	public AccountOverDrawnException(){

		super();

	}

	public AccountOverDrawnException(String msg){

		super(msg);

	}
}
