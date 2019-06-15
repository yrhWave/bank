/**
 * Copyright (C), 2018, JXAU
 * FileName: managerActionForm
 * Author:   YRH
 * Date:     2018/9/3 22:58
 * Description: 业务ActionForm
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.forms;

import org.apache.struts.action.ActionForm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈业务ActionForm〉
 *
 * @author YRH
 * @create 2018/9/3
 * @since 1.0.0
 */
public class managerActionForm extends ActionForm {

    double money;
    double zMoney;
    double zName;


    public double getzName() {
        return zName;
    }

    public void setzName(double zName) {
        this.zName = zName;
    }



    public double getzMoney() {
        return zMoney;
    }

    public void setzMoney(double zMoney) {
        this.zMoney = zMoney;
    }

    public double getMoney() {

        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}