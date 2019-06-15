/**
 * Copyright (C), 2018, JXAU
 * FileName: FileDaoImpl
 * Author:   YRH
 * Date:     2018/7/22 16:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.dao;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author YRH
 * @create 2018/7/22
 * @since 1.0.0
 */

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 持久层
 *
 * @author YRH
 * @date 2018.7
 */

public class FileDaoImpl implements BankDaoInterface {
    UserBean u = new UserBean();
    MD5 md5 = new MD5();


    /**
     * 存储余额
     *
     * @param money
     * @throws IOException
     */
    @Override
    public boolean saveMoney(double money) throws IOException {

        File f = new File(u.getUserName() + ".properties");

        FileInputStream fis = new FileInputStream(f);
        Properties prop = new Properties();
        prop.load(fis);
        fis.close();
        prop.setProperty("money", String.valueOf(money));
        FileOutputStream fos = new FileOutputStream(f);
        prop.store(fos, "");
        fos.close();
        return true;
    }


    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean register(String userName, String password) throws IOException {

        File f = new File(userName + ".properties");
        if (f.exists()) {
            System.out.println("该用户名已被注册!");
            return false;
        } else {
            if ("".equals(userName) || "".equals(password)) {
                System.out.println("用户名或密码不能为空！");
                return false;
            } else {
                try {
                    FileOutputStream fos = new FileOutputStream(f);
                    Properties prop = new Properties();
                    password = md5.encode(password.getBytes());//md5加密
                    prop.setProperty("uesrName", userName);
                    prop.setProperty("password", password);
                    prop.setProperty("money", String.valueOf(0.0));
                    prop.store(fos, userName + ".properties");
                    System.out.println("注册成功！");
                    return true;
                } catch (IOException e) {
                    System.out.println("文件读取错误！");
                    return false;
                }
            }

        }
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean login(String userName, String password) throws IOException {
        File f = new File(userName + ".properties");
        //判断用户名是否存在
        if (f.exists()) {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(f);
            prop.load(fis);
            password = md5.encode(password.getBytes());
            //判断用户名密码是否正确
            //if(userName.equals(prop.getProperty("userName")) && password.equals(prop.getProperty("password")))
            // if(userName.equals(prop.getProperty("userName")))
            if (password.equals(prop.getProperty("password"))) {
                MoneyBean.getInstance().setMoney(Double.parseDouble(prop.getProperty("money")));
                u.setUserName(userName);
                System.out.println("登录成功！");
                fis.close();
                return true;
            } else {
                System.out.println("用户名或密码错误！");
                fis.close();
                return false;
            }
        } else {
            System.out.println("用户名不存在！");
            return false;
        }
    }


    /**
     * 账户转账
     *
     * @param name   转账账户名
     * @param zMoney 转账金额
     * @return boolean
     * @Exception throws IOException
     */
    @Override
    public boolean transfer(String zName, double zMoney) throws IOException//,InputMismatchException
    {
        File f1 = new File(u.getUserName() + ".properties");
        File f2 = new File(zName + ".properties");
        FileInputStream fis = new FileInputStream(f1);
        Properties prop = new Properties();
        prop.load(fis);
        fis.close();
        if (f2.exists()) {
            FileInputStream fis1 = new FileInputStream(f2);
            Properties prop1 = new Properties();
            prop1.load(fis1);
            fis1.close();

            if (zMoney < 0) {
                System.out.println("转账金额不能为负！");
                return false;
            } else if (Double.parseDouble(prop.getProperty("money")) >= zMoney) {
                double d0 = Double.parseDouble(prop.getProperty("money")) - zMoney;
                prop.setProperty("money", String.valueOf(d0));
                FileOutputStream fos = new FileOutputStream(f1);
                prop.store(fos, "");
                fos.close();
                double d1 = Double.parseDouble(prop1.getProperty("money")) + zMoney;
                prop1.setProperty("money", String.valueOf(d1));
                FileOutputStream fos2 = new FileOutputStream(f2);
                prop1.store(fos2, "");
                fos2.close();
                return true;
            } else {
                System.out.println("余额不足无法转账");
                return false;
            }
        } else {
            System.out.println("账户不存在");
            return false;
        }

    }


    /**
     * 获取余额
     *
     * @param 无
     * @return double
     * @throws IOException
     */
    @Override
    public double getBalance() throws IOException {
        File f = new File(u.getUserName() + ".properties");
        FileInputStream fis = new FileInputStream(f);
        Properties prop = new Properties();
        prop.load(fis);
        double money = (Double.parseDouble(prop.getProperty("money")));
        fis.close();
        return money;
    }
}
