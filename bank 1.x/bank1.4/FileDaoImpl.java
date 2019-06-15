
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
     * 持久层
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
	 * 获取单一实例的静态方法
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
	  * 存储余额
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
	 * 用户注册
	 * @param userName 用户名
	 * @param password 密码
	 * @return boolean
	 * @throws IOException
	 */
	 public boolean register(String userName,String password)throws IOException
	{
		 //String name = user.getUserName();
		 //String password = user.getPassword();
		 File f = new File(userName+".properties");
		 if(f.exists()){
		 	System.out.println("该用户名已被注册!");
			return false;
		 }else{
		       if("".equals(userName) || "".equals(password)){
			   System.out.println("用户名或密码不能为空！");
			   return false;
			   }
		 else{
		     try{
			     // FileInputStream fis = new FileInputStream(new File("bank.properties"));
				  FileOutputStream fos = new FileOutputStream(f);
				  Properties prop = new Properties();
				  password = md5.encode(password.getBytes());//md5加密
				  prop.setProperty("uesrName",userName);
				  prop.setProperty("password",password);
				  //prop.setProperty("money","10");
				  prop.setProperty("money",String.valueOf(0.0));
				  prop.store(fos, userName +".properties");
				  //prop.close();
				  System.out.println("注册成功！");
				  return true;
			 }catch(IOException e){
			      System.out.println("文件读取错误！");
				  return false;
			 }
		 }
		 
	 }
	}
	  /**
	 * 用户登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return boolean
	 * @throws IOException
	 */
	  public boolean login(String userName,String password)throws IOException
	 {
		  File f = new File(userName+".properties");
		  //判断用户名是否存在
		  if(f.exists()){
		      Properties prop=new Properties();
			  FileInputStream fis = new FileInputStream(f);
			  prop.load(fis);
			  password = md5.encode(password.getBytes());
			  //判断用户名密码是否正确
			//if(userName.equals(prop.getProperty("userName")) && password.equals(prop.getProperty("password")))
			   	 // if(userName.equals(prop.getProperty("userName")))
				  if(password.equals(prop.getProperty("password")))
			  {
			      MoneyBean.getInstance().setMoney(Double.parseDouble(prop.getProperty("money")));
				  u.setUserName(userName);
				  System.out.println("登录成功！");
				  fis.close();
				  return true;
			  }else{
			      System.out.println("用户名或密码错误！");
				  fis.close();
				  return false;
			  }
		  }else{
			  System.out.println("用户名不存在！");
			 // fis.close();
			  return false;
		  }
	 }


	   /**
	*账户转账
	*@param String 转账账户名
	*@param double 转账金额
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
			System.out.println("请输入转账金额");
			double money=in1.nextDouble();
			if(money<0){
				System.out.println("转账金额不能为负！");
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
				System.out.println("余额不足无法转账");
				return false;
			}
		  }else{
			System.out.println("账户不存在");
			return false;
		}

	  }


	  /**
	*获取余额
	*@param 无
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
