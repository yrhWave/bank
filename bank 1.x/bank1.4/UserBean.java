
package com.cx.bank.model;

/**
 * @UserBean�����ڷ�װ�û�����
 * @author YRH
 * @date 2018.7
*/

public class  UserBean
{
	private String userName;//�û���
	private String password;//����
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
     *  �����û���
	 *  setUserName����
	 *  @param userName
	*/

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	

    /**
	 *  ��ȡ�û���
	 *  getUserName����
	 *  @return username
	*/

	public String getUserName()
	{
		return this.userName;
	}


	/**
	 * ��������
	 * @setPassword ����
	 * @param password
	 */

	 public void setPassword(String password)
	{
		 this.password = password;
	  }

   /**
     *  ��ȡ����
	 *  getPassword����
	 *  @return Password
	*/

	public String getPassword()
	{
		return this.password;
	}

}
