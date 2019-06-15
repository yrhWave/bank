/**
 * Copyright (C), 2018, JXAU
 * FileName: AccountOverDrawnException
 * Author:   YRH
 * Date:     2018/8/20 19:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author YRH
 * @create 2018/8/20
 * @since 1.0.0
 */
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