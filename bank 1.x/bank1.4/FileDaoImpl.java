
    package com.cx.bank.dao;

    import  java.io.File;
    import  java.io.FileInputStream;
	import  java.io.FileNotFoundException;
	import  java.io.FileOutputStream;
	import  java.io.IOException;
	import java.util.InputMismatchException;
	import  java.util.Properties;
	import  java.util.Scanner;

	import  com.cx.bank.model.MoneyBean;
	import  com.cx.bank.model.UserBean;
	import  com.cx.bank.util.MD5;

	/**
     * �־ò�
     * @author YRH
     * @date 2018.7
    */

public class  FileDaoImpl implements BankDaoInterface	
{
	//MoneyBean money = MoneyBean.getInstance( );
    UserBean u = new UserBean();
	MD5 md5 = new MD5();
	//private static FileDaoImpl  instance = null;

	//private FileDaoImpl ( )
	//{
	//}

	/**
	 * ��ȡ��һʵ���ľ�̬����
	 * @return
	 */
     /*public static FileDaoImpl getInstance()
	{	
	if (instance==null)
		{
			instance = new FileDaoImpl();
		}
		return instance;
	}
*/
	 /**
	  * �洢���
	  * @param money
	  * @throws IOException
	 */
	 public void saveMoney(double money) throws IOException
	{
		 //String name = u.getUserName;
		 //File f = new File (u.getUserName+".properties");
	
		 File f=new File(u.getUserName()+".properties");
		 
		 FileInputStream fis = new FileInputStream(f);
		 Properties prop = new Properties();
		 prop.load(fis);
		 fis.close();
		 prop.setProperty("money",String.valueOf(money));
		 FileOutputStream fos=new FileOutputStream(f);
		 prop.store(fos,"");
		 fos.close();
	 }


	 /**
	 * �û�ע��
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	 public boolean register(String userName,String password)throws IOException
	{
		 //String name = user.getUserName();
		 //String password = user.getPassword();
		 File f = new File(userName+".properties");
		 if(f.exists()){
		 	System.out.println("���û����ѱ�ע��!");
			return false;
		 }else{
		       if("".equals(userName) || "".equals(password)){
			   System.out.println("�û��������벻��Ϊ�գ�");
			   return false;
			   }
		 else{
		     try{
			     // FileInputStream fis = new FileInputStream(new File("bank.properties"));
				  FileOutputStream fos = new FileOutputStream(f);
				  Properties prop = new Properties();
				  password = md5.encode(password.getBytes());//md5����
				  prop.setProperty("uesrName",userName);
				  prop.setProperty("password",password);
				  //prop.setProperty("money","10");
				  prop.setProperty("money",String.valueOf(0.0));
				  prop.store(fos, userName +".properties");
				  //prop.close();
				  System.out.println("ע��ɹ���");
				  return true;
			 }catch(IOException e){
			      System.out.println("�ļ���ȡ����");
				  return false;
			 }
		 }
		 
	 }
	}
	  /**
	 * �û���¼
	 * @param userName �û���
	 * @param password ����
	 * @return boolean
	 * @throws IOException
	 */
	  public boolean login(String userName,String password)throws IOException
	 {
		  File f = new File(userName+".properties");
		  //�ж��û����Ƿ����
		  if(f.exists()){
		      Properties prop=new Properties();
			  FileInputStream fis = new FileInputStream(f);
			  prop.load(fis);
			  password = md5.encode(password.getBytes());
			  //�ж��û��������Ƿ���ȷ
			//if(userName.equals(prop.getProperty("userName")) && password.equals(prop.getProperty("password")))
			   	 // if(userName.equals(prop.getProperty("userName")))
				  if(password.equals(prop.getProperty("password")))
			  {
			      MoneyBean.getInstance().setMoney(Double.parseDouble(prop.getProperty("money")));
				  u.setUserName(userName);
				  System.out.println("��¼�ɹ���");
				  fis.close();
				  return true;
			  }else{
			      System.out.println("�û������������");
				  fis.close();
				  return false;
			  }
		  }else{
			  System.out.println("�û��������ڣ�");
			 // fis.close();
			  return false;
		  }
	 }


	   /**
	*�˻�ת��
	*@param String ת���˻���
	*@param double ת�˽��
	*@return boolean
	*@Exception throws IOException
	*/
	  public boolean transfer(String name)throws IOException//,InputMismatchException
	{
		  File f1 =new File(u.getUserName()+".properties");
		  File f2 =new File(name+".properties");
		  FileInputStream fis = new FileInputStream(f1);
		  Properties prop = new Properties();
		  prop.load(fis);
		  fis.close();
		  if(f2.exists()){
		    FileInputStream fis1=new FileInputStream(f2);
			Properties prop1=new Properties();
			prop1.load(fis1);
			fis1.close();
			Scanner in1=new Scanner(System.in);
			System.out.println("������ת�˽��");
			double money=in1.nextDouble();
			if(money<0){
				System.out.println("ת�˽���Ϊ����");
				return false;
			}else if(Double.parseDouble(prop.getProperty("money"))>=money){
				double d0=Double.parseDouble(prop.getProperty("money"))-money;
				prop.setProperty("money",String.valueOf(d0));
				FileOutputStream fos=new FileOutputStream(f1);
				prop.store(fos,"");
				fos.close();
				double d1=Double.parseDouble(prop1.getProperty("money"))+money;
				prop1.setProperty("money",String.valueOf(d1));
				FileOutputStream fos2=new FileOutputStream(f2);
				prop1.store(fos2,"");
				fos2.close();
				return true;
			}else{
				System.out.println("�����޷�ת��");
				return false;
			}
		  }else{
			System.out.println("�˻�������");
			return false;
		}

	  }


	  /**
	*��ȡ���
	*@param ��
	*@return double
	*@throws IOException
	*/
	public double getBalance()throws IOException
	{
		File f=new File(u.getUserName()+".properties");
		//System.out.println(u.getUserName());
		//System.out.println(f.exists());
		FileInputStream fis=new FileInputStream(f);
		Properties prop=new Properties();
		prop.load(fis);
		//fis.close();
		double money=(Double.parseDouble(prop.getProperty("money")));
		fis.close();
		return money;
	}
}
