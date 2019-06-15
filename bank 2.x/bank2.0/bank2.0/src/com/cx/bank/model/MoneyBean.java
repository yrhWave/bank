/**
 * Copyright (C), 2018, JXAU
 * FileName: MoneyBean
 * Author:   YRH
 * Date:     2018/8/20 17:41
 * Description: 账户余额实体bean
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈账户余额实体bean〉
 *
 * @author YRH
 * @create 2018/8/20
 * @since 1.0.0
 */
public class MoneyBean
{
    //账户余额
    private double money;

    private static MoneyBean instance;

    /**
     *  无参构造方法
     */
    private MoneyBean()
    {

    }

    public static MoneyBean getInstance()
    {
        if (instance==null)
        {
            instance = new MoneyBean();
        }
        return instance;
    }


    /**
     *  set方法
     *  @param money
     */

    public void setMoney(double money)
    {
        this.money = money;
    }


    /**
     *  get方法
     *  @return
     */

    public double getMoney()
    {
        return money;
    }

}
