
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
 * ����һ���־ò�ӿ�
 * @data 2018.7
 * @author YRH
 */

 public interface BankDaoInterface
 {
	 /**
	  * �洢���
	  * @param money
	  * @throws IOException
	 */
	 void saveMoney(double money) throws IOException;

	 /**
	 * �û�ע��
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	 boolean register(String userName,String password)throws IOException;


	  /**
	 * �û���½
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	  boolean login(String userName,String password)throws IOException;

	  	  /**
	*��ȡ���
	*@param ��
	*@return double
	*@throws IOException
	*/
	double getBalance( )throws IOException;

   /**
	*�˻�ת��
	*@param String ת���˻���
	*@param double ת�˽��
	*@return boolean
	*@Exception throws IOException
	*/
	  boolean transfer(String name)throws IOException;

 }