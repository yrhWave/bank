/**
 * Copyright (C), 2018, JXAU
 * FileName: JDBCUtil
 * Author:   YRH
 * Date:     2018/8/13 17:07
 * Description: JDBC工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈JDBC工具类〉
 *
 * @author YRH
 * @create 2018/8/13
 * @since 1.0.0
 */
public class JDBCUtil {

    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;

    static{
        try{
            //创建一个属性配置对象
            Properties properties = new Properties();
            InputStream is = new FileInputStream("D:\\IdeaProjects\\bank2.0\\src\\jdbc.properties");
            //导入输入流
            properties.load(is);
            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConn(){
            Connection conn = null;
            try {
                //注册驱动
                Class.forName(driverClass);
                //建立连接
                conn = DriverManager.getConnection(url,name,password);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn , Statement st , ResultSet rs){
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }
    public static void release(Connection conn , Statement st ){
        closeSt(st);
        closeConn(conn);
    }


    private static void closeRs(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            rs = null;
        }
    }

    private static void closeSt(Statement st){
        try {
            if(st != null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            st = null;
        }
    }

    private static void closeConn(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn = null;
        }
    }
}
