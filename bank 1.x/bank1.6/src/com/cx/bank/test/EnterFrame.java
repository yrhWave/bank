/**
 * Copyright (C), 2018, JXAU
 * FileName: EnterFrame
 * Author:   YRH
 * Date:     2018/7/22 17:29
 * Description: 登录界面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.test;

import com.cx.bank.manager.ManagerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 〈登录界面〉<br>
 *
 * @author YRH
 * @create 2018/7/22
 * @since 1.0.0
 */
public class EnterFrame extends JFrame {

    /**
     * 用户名
     */
    private String uname;
    /**
     * 密码
     */
    private String upsd;
    /**
     * 用户名输入框
     */
    private JTextField unameTextField;
    /**
     * 密码输入框
     */
    private JTextField upsdTextField;

    /**
     * 无参构造方法
     */
    public EnterFrame() {

        //创建一个框架
        final JFrame enterFrame = new JFrame("银行管理系统");
        //创建两个面板
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        //创建组件
        JLabel NAME = new JLabel("天地银行");
        JLabel nameLabel = new JLabel("用户名：");
        JLabel psdLabel = new JLabel("密码:");
        unameTextField = new JTextField(10);
        upsdTextField = new JTextField(10);
        JButton bRegister = new JButton("注册");
        JButton bLogin = new JButton("登录");

        //添加事件监听器,匿名内部类
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //从文本框获得用户名及密码
                uname = unameTextField.getText();
                upsd = upsdTextField.getText();
                //定义一个flag标记，记录是否注册成功
                boolean flag = false;
                //传参出册，捕获异常信息
                try {
                    flag = ManagerImpl.getManager().register(uname, upsd);
                } catch (Exception e1) {
                    e1.getMessage();
                }
                //使用提示框提示用户是否注册成功
                if (flag == true) {
                    JOptionPane.showMessageDialog(null, "注册成功！", "注册", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "注册失败！", "注册", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        //添加事件监听器,匿名内部类
        bLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                uname = unameTextField.getText();
                upsd = upsdTextField.getText();
                boolean flag = false;
                try {
                    flag = ManagerImpl.getManager().login(uname, upsd);
                } catch (Exception e1) {
                    e1.getMessage();
                }
                if (flag == true) {
                    new HomeFrame();
                    enterFrame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "登录失败！请核对用户名密码！", "登录", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        //将面板panel设成网格布局，并向其中添加组件
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.add(nameLabel);
        panel.add(unameTextField);
        panel.add(psdLabel);
        panel.add(upsdTextField);
        panel.add(bRegister);
        panel.add(bLogin);

        //向面板panel1中添加组件
        panel1.add(NAME);

        //设置框架布局，并向其中添加面板。设置参数
        enterFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
        enterFrame.add(panel1);
        enterFrame.add(panel);
        enterFrame.setLocation(500, 400);
        enterFrame.setSize(300, 400);
        enterFrame.setResizable(false);
        enterFrame.setVisible(true);
        enterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}