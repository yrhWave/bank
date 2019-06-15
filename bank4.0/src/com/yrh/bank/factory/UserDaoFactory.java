/**
 * Copyright (C), 2018, JXAU
 * FileName: UserDaoFactory
 * Author:   YRH
 * Date:     2018/8/20 19:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.factory;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author YRH
 * @create 2018/8/20
 * @since 1.0.0
 */


import com.yrh.bank.dao.BankDaoInterface;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

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
        FileInputStream fis = new FileInputStream(new File("D:\\IdeaProjects\\bank4.0\\src\\classInfo.properties"));
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
