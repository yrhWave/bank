

package com.cx.bank.model;

  /**
    *ģ�Ͳ�
    *����һ���˻���
    *@author 6423
	*version 2018.6.20
    */
public class UserBean 
{
	private String userName;//�û���
	private String password;//����

	/**�����û���
	  *@param userName �û���
	  *@return ��
	  */
	public void setUserName(String userName){
		this.userName=userName;
	}
    /**��������
	  *@param passward ����
	  *@return ��
	  */
	public void setPassword(String password){
		this.password=password;
	}

	/**��ȡ�û���
	  *@param ��
	  *@return userName �û���
	  */
	public String getUserName(){
			return this.userName;
	}

	/**��ȡ����
	  *@param ��
	  *@return passward ����
	  */
	  public String getPassword(){
		return this.password;
	  }
	
}
