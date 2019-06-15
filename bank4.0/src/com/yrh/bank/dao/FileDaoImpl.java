/**
 * Copyright (C), 2018, JXAU
 * FileName: FileDaoImpl
 * Author:   YRH
 * Date:     2018/8/20 19:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.dao;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author YRH
 * @create 2018/8/20
 * @since 1.0.0
 */


import com.yrh.bank.model.UserBean;
import com.yrh.bank.util.AppException;
import com.yrh.bank.util.JDBCUtil;
import com.yrh.bank.util.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 持久层
 *
 * @author YRH
 * @date 2018.7
 */

public class FileDaoImpl implements BankDaoInterface {
    private UserBean u = new UserBean();
    private MD5 md5 = new MD5();

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public FileDaoImpl() {

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
    public boolean register(String userName, String password) throws IOException, SQLException {

        System.out.println(userName);
        System.out.println(password);
        File f = new File(userName + ".properties");
        if (f.exists()) {
            //该用户名已被注册
            return false;
        } else {
            if ("".equals(userName) || "".equals(password)) {
                //用户名或密码不能为空
                return false;
            } else {

                // 1. 获取连接对象
                conn = JDBCUtil.getConn();
                // 2. 根据连接对象，得到statement
                st = conn.createStatement();
                //sql语句，插入用户名以及余额信息
                String sql = "insert into users(userName,balance) values('" + userName + "',0)";
                //执行sql语句
                st.execute(sql);

                JDBCUtil.release(conn, st, rs);

                //文件操作，存储用户名以及密码
                FileOutputStream fos = new FileOutputStream(f);
                Properties prop = new Properties();
                //md5加密
                password = md5.encode(password.getBytes());
                prop.setProperty("userName", userName);
                prop.setProperty("password", password);
                prop.setProperty("money", String.valueOf(0.0));
                prop.store(fos, userName + ".properties");
                System.out.println("注册成功！");
                return true;

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
    public boolean login(String userName, String password) throws IOException, SQLException {

        File f = new File(userName + ".properties");
        //判断用户名是否存在
        if (f.exists()) {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(f);
            prop.load(fis);
            password = md5.encode(password.getBytes());
            //判断用户名密码是否正确
            if (password.equals(prop.getProperty("password"))) {
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
     * 存储余额
     *
     * @param money
     * @throws IOException
     */
    @Override
    public boolean saveMoney(double money, String userName) throws IOException, SQLException {

        double balance = getBalance(userName);
        // 获取连接对象
        conn = JDBCUtil.getConn();
        // 根据连接对象，得到statement
        st = conn.createStatement();

        System.out.println(balance);
        balance = balance + money;
        System.out.println(balance);
        String sql = "UPDATE users SET balance='" + balance + "'WHERE userName='" + userName + "'";
        //执行sql语句
        st.executeUpdate(sql);
        JDBCUtil.release(conn, st, rs);
        return true;
    }

    @Override
    public boolean withDraw(double money, String userName) throws IOException, SQLException {

        double balance = getBalance(userName);
        // 获取连接对象
        conn = JDBCUtil.getConn();
        // 根据连接对象，得到statement
        st = conn.createStatement();
        //获取余额
        balance = balance - money;
        String sql = "UPDATE users SET balance='" + balance + "'WHERE userName='" + userName + "'";
        st.executeUpdate(sql);
        JDBCUtil.release(conn, st, rs);
        return true;
    }

    /**
     * 账户转账
     *
     * @param zName  转账账户名
     * @param zMoney 转账金额
     * @return boolean
     * @Exception throws IOException
     */
    @Override
    public boolean transfer(String zName, double zMoney, String userName) throws IOException, SQLException {

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
                //转账金不能为负
                throw new AppException("error.transfer.money.negative");
            } else if (getBalance(userName) >= zMoney) {
                //获取当前用余额
                double balance = getBalance(userName);
                // 获取连接对象
                conn = JDBCUtil.getConn();
                // 根据连接对象，得到statement
                st = conn.createStatement();
                //余额减去转账金额
                balance = balance - zMoney;
                //定义SQL语句
                String sql = "UPDATE users SET balance='" + balance + "'WHERE userName='" + userName + "'";
                //执行语句
                st.executeUpdate(sql);
                sql = "SELECT * FROM users where userName='" + zName + "'";
                //执行sql语句
                rs = st.executeQuery(sql);
                //遍历结果集
                double balance1 = 0;
                while (rs.next()) {
                    balance1 = rs.getDouble("balance");
                }
                balance1 += zMoney;
                sql = "UPDATE users SET balance='" + balance1 + "'WHERE userName='" + zName + "'";
                //执行语句
                st.executeUpdate(sql);
                JDBCUtil.release(conn, st, rs);
                return true;
            } else {
                System.out.println("余额不足无法转账");
                throw new AppException("error.transfer.money.insufficient");
            }
        } else {
            System.out.println("账户不存在");
            throw new AppException("error.transfer.money.nopayee");
        }


    }


    /**
     * 获取余额
     *
     * @return double
     * @throws IOException
     */
    @Override
    public double getBalance(String userName) throws IOException, SQLException {

        // 获取连接对象
        conn = JDBCUtil.getConn();
        // 根据连接对象，得到statement
        st = conn.createStatement();
        //sql语句，插入用户名以及余额信息
        String sql = "SELECT * FROM users where userName='" + userName + "'";
        //执行sql语句
        rs = st.executeQuery(sql);
        //遍历结果集
        double balance = 0;
        while (rs.next()) {
            balance = rs.getDouble("balance");
        }
        JDBCUtil.release(conn, st, rs);
        System.out.println("gb" + balance);
        System.out.println("uN" + userName);
        return balance;
    }
}