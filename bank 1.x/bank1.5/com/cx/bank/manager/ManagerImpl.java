/**
 * Copyright (C), 2018, JXAU
 * FileName: ManagerImpl
 * Author:   YRH
 * Date:     2018/7/22 16:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.manager;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author YRH
 * @create 2018/7/22
 * @since 1.0.0
 */

import com.cx.bank.dao.BankDaoInterface;
import com.cx.bank.dao.FileDaoImpl;
import com.cx.bank.factory.UserDaoFactory;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import java.io.IOException;
/**
 * 业务层
 * @author YRH
 * @date 2018.7
 * @verson bank v1.3
 */



public class  ManagerImpl implements ManagerInterface

{
    private static ManagerImpl manager = null;
    MoneyBean m = MoneyBean.getInstance( );
    private BankDaoInterface userDao = null;
    private BankDaoInterface b = new FileDaoImpl();


    private ManagerImpl( )throws Exception
    {
        UserDaoFactory DaoFactory= UserDaoFactory.getInstance();
        userDao =DaoFactory.createUserDao();
    }

    public static ManagerImpl getManager()throws Exception
    {
        if (manager==null)
        {
            manager = new ManagerImpl();
        }
        return manager;
    }

    /**
     * 用户注册
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean register(String userName,String password)throws IOException
    {
        boolean flag = b.register(userName,password);
        return flag;
    }


    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return boolean
     * @throws IOException
     */
    @Override
    public boolean login(String userName,String password)throws IOException
    {

        boolean flag = b.login(userName,password);
        return flag;
    }

    /**
     * 账户转账
     * @param zName 转入用户名
     * @param zMoney 转账金额
     * @return boolean
     * @throws IOException
     */
    @Override
    public  boolean transfer(String zName,double zMoney)throws IOException
    {
        boolean flag=b.transfer(zName,zMoney);
        return flag;
    }


    /**
     *  查询方法
     *  @return
     */
    @Override
    public double inquiry()throws IOException
    {
        m.setMoney(b.getBalance());
        return m.getMoney();
    }


    /**
     *  取款方法
     *  实现“余额不足”的逻辑判断
     *  @param money
     */
    @Override
    public boolean withdrawals(double money) throws AccountOverDrawnException,IOException
    {
        if(b.getBalance()<money || money < 0) {
            //如果用户取款金额大于余额，抛出AccountOverDrawnException异常
            throw new AccountOverDrawnException("请输入正确取款金额！");
        }
        boolean flag = b.saveMoney(b.getBalance() - money);
        return flag;
    }


    /**
     *  存款方法
     *  实现“存款不能为负”的逻辑判断
     *  @param money
     */
    @Override
    public boolean deposit(double money) throws InvalidDepositException,IOException
    {
        if(money<=0) {
            /**如果用户存款为负数，抛出InvalidDepositException异常*/
            throw new InvalidDepositException("存款金额不能为负!");
        }
        boolean flag = b.saveMoney(b.getBalance() + money);
        return flag;

    }

    /**
     *  退出系统
     */
    @Override
    public void exitSystem()
    {
        System.out.println("系统已退出！");
        System.exit(1);
    }

}
