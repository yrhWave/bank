package com.cx.bank.dao;

import java.io.IOException;

/**
*�־ò�ӿ�
*����һ���ӿ�
*@author 6423
*@version 2018.7.7
*/
public interface BankDaoInterface{
	void saveMoney(double money)throws IOException;
	boolean register(String userName,String password)throws IOException;
	boolean login(String userName,String password)throws IOException;
	double getBalance()throws IOException;
	boolean transfer(String name)throws IOException;
}