/**
 * Copyright (C), 2018, JXAU
 * FileName: InvaliWithdrawalException
 * Author:   YRH
 * Date:     2018/8/21 9:05
 * Description: 取款不能为负数，为负数时抛异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈取款不能为负数，为负数时抛异常〉
 *
 * @author YRH
 * @create 2018/8/21
 * @since 1.0.0
 */
public class InvaliWithdrawalException extends Exception{

    public InvaliWithdrawalException(){

        super();

    }

    public InvaliWithdrawalException(String msg){

        super(msg);

    }

}