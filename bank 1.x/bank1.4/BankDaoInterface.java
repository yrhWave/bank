
    package com.cx.bank.dao;

    import  java.io.File;
    import  java.io.FileInputStream;
	import  java.io.FileNotFoundException;
	import  java.io.FileOutputStream;
	import  java.io.IOException;
	import  java.util.Properties;

	import  com.cx.bank.model.MoneyBean;
	import  com.cx.bank.model.UserBean;
	import  com.cx.bank.util.MD5;

/**
 * 定义一个持久层接口
 * @data 2018.7
 * @author YRH
 */

 public interface BankDaoInterface
 {
	 /**
	  * 存储余额
	  * @param money
	  * @throws IOException
	 */
	 void saveMoney(double money) throws IOException;

	 /**
	 * 用户注册
	 * @param userName 用户名
	 * @param password 密码
	 * @return boolean
	 * @throws IOException
	 */
	 boolean register(String userName,String password)throws IOException;


	  /**
	 * 用户登陆
	 * @param userName 用户名
	 * @param password 密码
	 * @return boolean
	 * @throws IOException
	 */
	  boolean login(String userName,String password)throws IOException;

	  	  /**
	*获取余额
	*@param 无
	*@return double
	*@throws IOException
	*/
	double getBalance( )throws IOException;

   /**
	*账户转账
	*@param String 转账账户名
	*@param double 转账金额
	*@return boolean
	*@Exception throws IOException
	*/
	  boolean transfer(String name)throws IOException;

 }