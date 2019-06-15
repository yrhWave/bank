/**
 * Copyright (C), 2018, JXAU
 * FileName: InvalidDepositException
 * Author:   YRH
 * Date:     2018/7/22 16:56
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
 * @create 2018/7/22
 * @since 1.0.0
 */

/**
 * 存款为负数时抛出异常
 * @date 2018.6
 * @author YRH
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
