

package com.cx.bank.model;

  /**
    *模型层
    *定义一个账户类
    *@author 6423
	*version 2018.6.20
    */
public class UserBean 
{
	private String userName;//用户名
	private String password;//密码

	/**设置用户名
	  *@param userName 用户名
	  *@return 无
	  */
	public void setUserName(String userName){
		this.userName=userName;
	}
    /**设置密码
	  *@param passward 密码
	  *@return 无
	  */
	public void setPassword(String password){
		this.password=password;
	}

	/**获取用户名
	  *@param 无
	  *@return userName 用户名
	  */
	public String getUserName(){
			return this.userName;
	}

	/**获取密码
	  *@param 无
	  *@return passward 密码
	  */
	  public String getPassword(){
		return this.password;
	  }
	
}
