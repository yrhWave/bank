
package com.cx.bank.model;

/**
 * @UserBean，用于封装用户数据
 * @author YRH
 * @date 2018.7
*/

public class  UserBean
{
	private String userName;//用户名
	private String password;//密码
/*
	private double UserBean;
	
	private static UserBean instance;

		private UserBean()
	{

	}

	public static UserBean getInstance()
	{	
	if (instance==null)
		{
			instance = new UserBean();
		}
		return instance;
	}
*/

   /**
     *  设置用户名
	 *  setUserName方法
	 *  @param userName
	*/

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	

    /**
	 *  获取用户名
	 *  getUserName方法
	 *  @return username
	*/

	public String getUserName()
	{
		return this.userName;
	}


	/**
	 * 设置密码
	 * @setPassword 方法
	 * @param password
	 */

	 public void setPassword(String password)
	{
		 this.password = password;
	  }

   /**
     *  获取密码
	 *  getPassword方法
	 *  @return Password
	*/

	public String getPassword()
	{
		return this.password;
	}

}
