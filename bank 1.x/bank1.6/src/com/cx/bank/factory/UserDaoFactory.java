
package com.cx.bank.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.cx.bank.dao.*;


/**
 * 工厂类，装配FileDaoImpl
 *
 * @author YRH
 */
public class UserDaoFactory {

    private static UserDaoFactory instance;

    private BankDaoInterface userDao;

    private UserDaoFactory() throws Exception {

        //创建属性对象
        Properties p = new Properties();
        //创建流对象
        FileInputStream fis = new FileInputStream(new File("classInfo.properties"));
        //加载
        p.load(fis);
        //关闭流
        fis.close();

        //通过key获取value获取类文件名
        String className = p.getProperty("className");
        //加载类创建映射对象
        Class c = Class.forName(className);
        //创建对象
        Object o = c.newInstance();
        userDao = (BankDaoInterface) o;


    }

    public static synchronized UserDaoFactory getInstance() throws Exception {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    /**
     * 创建UserDao对象
     *
     * @return UserDao
     */
    public BankDaoInterface createUserDao() {
        return userDao;
    }
}
