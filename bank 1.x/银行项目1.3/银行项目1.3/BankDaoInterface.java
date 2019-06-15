package com.cx.bank.dao;

import java.io.IOException;

/**
*持久层接口
*定义一个接口
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