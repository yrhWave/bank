/**
 * Copyright (C), 2018, JXAU
 * FileName: transferToOneselfException
 * Author:   YRH
 * Date:     2018/8/25 22:47
 * Description: 转账给自己异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈转账给自己异常〉
 *
 * @author YRH
 * @create 2018/8/25
 * @since 1.0.0
 */
public class transferToOneselfException extends Exception{
    public transferToOneselfException(){

        super();

    }

    public transferToOneselfException(String msg){

        super(msg);

    }

}