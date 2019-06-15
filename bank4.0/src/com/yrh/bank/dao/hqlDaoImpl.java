/**
 * Copyright (C), 2018, JXAU
 * FileName: hqlDaoImpl
 * Author:   YRH
 * Date:     2018/9/13 19:24
 * Description: dao层使用Hibernate操作数据库
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.dao;

/**
 * 〈一句话功能简述〉<br>
 * 〈dao层使用Hibernate操作数据库〉
 *
 * @author YRH
 * @create 2018/9/13
 * @since 1.0.0
 */

import com.yrh.bank.model.User;
import com.yrh.bank.model.UserBean;
import com.yrh.bank.util.AppException;
import com.yrh.bank.util.HibernateUtils;
import com.yrh.bank.util.MD5;
import org.hibernate.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * 持久层
 *
 * @author YRH
 * @date 2018.7
 */

public class hqlDaoImpl implements BankDaoInterface {
    private UserBean u = new UserBean();
    private MD5 md5 = new MD5();

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    public hqlDaoImpl() {

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

        File f = new File(userName + ".properties");
        if (f.exists()) {
            //该用户名已被注册
            return false;
        } else {

            Session session = null;
            User user;
            try {
                session = HibernateUtils.getSession();
                session.beginTransaction();

                user = new User();
                user.setUserName(userName);
                user.setBalance(0);
                session.save(user);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            } finally {
                HibernateUtils.closeSession(session);
            }

            //文件操作，存储用户名以及密码
            FileOutputStream fos = new FileOutputStream(f);
            Properties prop = new Properties();
            //md5加密
            password = md5.encode(password.getBytes());
            prop.setProperty("userName", userName);
            prop.setProperty("password", password);
            prop.setProperty("money", String.valueOf(0.0));
            prop.store(fos, userName + ".properties");
            return true;

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
                //登录成功
                fis.close();
                return true;
            } else {
                //用户名或密码错误
                fis.close();
                return false;
            }
        } else {
            //用户名不存在
            return false;
        }
    }

    /**
     * 存款
     *
     * @param money
     * @param userName
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public boolean saveMoney(double money, String userName) throws IOException, SQLException {

        double balance = getBalance(userName);
        balance = balance + money;
        int id = findIdByName(userName);
        setBalanceInUser(id, balance);
        return true;
    }

    /**
     * 取款
     *
     * @param money
     * @param userName
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public boolean withDraw(double money, String userName) throws IOException, SQLException {

        double balance = getBalance(userName);
        balance = balance - money;
        int id = findIdByName(userName);
        setBalanceInUser(id, balance);
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
                balance -= zMoney;
                int id = findIdByName(userName);
                setBalanceInUser(id, balance);

                double balance1 = getBalance(zName);
                balance1 += zMoney;
                int id1 = findIdByName(zName);
                setBalanceInUser(id1, balance1);

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

        Session session = null;
        double balance = 0;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            List user = session.createQuery("select u.balance from User u where u.userName=" + userName).list();
            for (Iterator iter = user.iterator(); iter.hasNext(); ) {
                balance = (double) iter.next();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return balance;
    }

    public int findIdByName(String userName) {
        Session session = null;
        int id = 0;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            List user = session.createQuery("select u.id from User u where u.userName=" + userName).list();
            for (Iterator iter = user.iterator(); iter.hasNext(); ) {
                id = (int) iter.next();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return id;
    }

    /**
     * @param id
     * @param balance
     */
    public void setBalanceInUser(int id, double balance) {
        Session session = null;
        User user;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            user = (User) session.load(User.class, id);
            user.setBalance(balance);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }

    }
}
