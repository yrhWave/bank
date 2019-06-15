
 package com.cx.bank.factory;

 import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.cx.bank.dao.*;

 

 
/**
 * �����࣬װ��FileDaoImpl
 */
public class UserDaoFactory {
	
	private static UserDaoFactory instance;
	
	private BankDaoInterface userDao;
	
	private UserDaoFactory()throws Exception {

	    Properties p=new Properties();//�������Զ��� 
	    FileInputStream fis=new FileInputStream(new File("classInfo.properties"));//����������
		p.load(fis);//����
		fis.close();//�ر���
		
		String className=p.getProperty("className");//ͨ��key��ȡvalue��ȡ���ļ���
		Class c=Class.forName(className);//�����ഴ��ӳ�����
	    Object o=c.newInstance();//��������
		userDao =(BankDaoInterface)o;
	
		
	}
	
	public static synchronized UserDaoFactory getInstance()throws Exception {
		if (instance == null) {
			instance = new UserDaoFactory();
		}
		return instance;
	}
	
	/**
	 * ����UserDao����
	 * @return UserDao
	 */
	public BankDaoInterface createUserDao() {
		return userDao;
	}
}
