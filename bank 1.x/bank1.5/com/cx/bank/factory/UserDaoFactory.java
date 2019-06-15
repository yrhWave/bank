
package com.cx.bank.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.cx.bank.dao.*;




/**
 * 工厂类，装配FileDaoImpl
 */
public class UserDaoFactory {

    private static UserDaoFactory instance;

    private BankDaoInterface userDao;

    private UserDaoFactory()throws Exception {

        Properties p=new Properties();//创建属性对象
        FileInputStream fis=new FileInputStream(new File("classInfo.properties"));//创建流对象
        p.load(fis);//加载
        fis.close();//关闭流

        String className=p.getProperty("className");//通过key获取value获取类文件名
        Class c=Class.forName(className);//加载类创建映射对象
        Object o=c.newInstance();//创建对象
        userDao =(BankDaoInterface)o;


    }

    public static synchronized UserDaoFactory getInstance()throws Exception {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    /**
     * 创建UserDao对象
     * @return UserDao
     */
    public BankDaoInterface createUserDao() {
        return userDao;
    }
}
