/**
 * Copyright (C), 2018, JXAU
 * FileName: InvalidDepositException
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
 * 〈存款为负数时抛出异常〉
 *
 * @author YRH
 * @create 2018/8/20
 * @since 1.0.0
 */

@SuppressWarnings("serial")
public class InvalidDepositException extends Exception
{
    public InvalidDepositException(){

        super();

    }

    public InvalidDepositException(String msg){

        super(msg);

    }
}
