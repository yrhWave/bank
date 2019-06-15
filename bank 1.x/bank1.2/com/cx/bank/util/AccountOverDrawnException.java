
package com.cx.bank.util;

/**
 * 取款超出余额时抛出异常
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
