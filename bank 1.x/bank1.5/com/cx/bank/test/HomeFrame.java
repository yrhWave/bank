/**
 * Copyright (C), 2018, JXAU
 * FileName: HomeFrame
 * Author:   YRH
 * Date:     2018/7/22 19:49
 * Description: 主界面 操作界面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cx.bank.test;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈主界面 操作界面〉
 *
 * @author YRH
 * @create 2018/7/22
 * @since 1.0.0
 */
public class HomeFrame extends Frame {

    /**
     * 无参构造方法
     */

    public HomeFrame() {
        /**创建框架*/
        JFrame homeFrame = new JFrame();

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        JLabel label = new JLabel("欢迎使用天地银行");
        /**查询按钮*/
        JButton bInquiry = new JButton("查询");
        /**存款按钮*/
        JButton bDeposit = new JButton("存款");
        /**取款按钮*/
        JButton bWithdrawals = new JButton("取款");
        /**转账按钮*/
        JButton bTransfer = new JButton("转账");
        /**退出系统按钮*/
        JButton bExit = new JButton("退出系统");

        /**为查询按钮添加监听器，匿名内部类，实现查询方法*/
        bInquiry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double balance = ManagerImpl.getManager().inquiry();
                    JOptionPane.showMessageDialog(null, balance, "天地银行", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e1) {
                    e1.getMessage();
                }
            }
        });

        /**为存款按钮田间监听器，匿名内部类，实现存款方法*/
        bWithdrawals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WithdrawalsFrame();
            }
        });

        /**为取款按钮添加监听器，匿名内部类，实现取款方法*/
        bDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepositFrame();
            }
        });

        /**为转账按钮添加监听器，匿名内部类，实现转账方法*/
        bTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransferFrame();
            }
        });

        /**为退出按钮添加监听器，匿名内部类，实现退出系统*/
        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int exit = JOptionPane.showConfirmDialog(null, "是否退出系统？", "退出", JOptionPane.OK_CANCEL_OPTION);
                if(exit == JOptionPane.CANCEL_OPTION) {
                    return;
                } else if(exit == JOptionPane.OK_OPTION) {
                    try {
                        ManagerImpl.getManager().exitSystem();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });


        panel.setLayout(new GridLayout(5, 1, 5, 10));

        panel.add(bInquiry);
        panel.add(bWithdrawals);
        panel.add(bDeposit);
        panel.add(bTransfer);
        panel.add(bExit);

        panel1.setLayout(new GridLayout(1, 1));
        panel1.add(label);

        homeFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
        homeFrame.add(panel1);
        homeFrame.add(panel);
        homeFrame.setLocation(500, 400);
        homeFrame.setSize(300, 450);
        homeFrame.setResizable(false);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

/**
 * 取款界面
 */

class WithdrawalsFrame extends Frame {
    /**
     * 取款金额
     */
    double money;

    public WithdrawalsFrame() {
        /**创建一个框架*/
        final JFrame withdrawalsFrame = new JFrame();
        /**创建一个面板*/
        JPanel panel = new JPanel();

        /**创建组件*/
        JLabel label = new JLabel("取款金额：");
        final JTextField textField = new JTextField();
        JButton bConfirm = new JButton("确定");
        JButton bBack = new JButton("返回");

        /**设置面板布局，并向面板中添加组件*/
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.add(label);
        panel.add(textField);
        panel.add(bConfirm);
        panel.add(bBack);

        /**为确定按钮添加事件监听，实现存款*/
        bConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**从文本框获取取款金额*/
                money = Double.parseDouble(textField.getText());
                /**标记是否取款成功*/
                boolean flag = false;
                try {
                    flag = ManagerImpl.getManager().withdrawals(money);

                    /**取款操作反馈*/
                    if (flag == true) {
                        JOptionPane.showMessageDialog(null, "取款成功！当前余额为：" + ManagerImpl.getManager().inquiry(), "存款", JOptionPane.PLAIN_MESSAGE);
                        withdrawalsFrame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "操作失败，请重新选择您的操作！", "存款", JOptionPane.PLAIN_MESSAGE);
                        withdrawalsFrame.dispose();
                    }
                } catch (InvalidDepositException ide) {
                    JOptionPane.showMessageDialog(null, "存款金额不能为负数！");
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }

            }
        });
        /**为返回按钮添加事件监听，关闭当前窗口*/
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawalsFrame.dispose();
            }
        });
        /**将面板添加到框架中，并设置框架的相关信息*/
        withdrawalsFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
        withdrawalsFrame.add(panel);
        withdrawalsFrame.setSize(600, 400);
        withdrawalsFrame.setLocation(500, 400);
        withdrawalsFrame.setResizable(false);
        withdrawalsFrame.setVisible(true);
    }
}


/**
 * 存款界面
 */

class DepositFrame extends Frame {
    /**
     * 存款金额
     */
    double money;

    public DepositFrame() {
        /**创建一个框架*/
        final JFrame depositFrame = new JFrame();
        /**创建一个面板*/
        JPanel panel = new JPanel();

        /**创建组件*/
        JLabel label = new JLabel("存款金额：");
        final JTextField textField = new JTextField();
        JButton bConfirm = new JButton("确定");
        JButton bBack = new JButton("返回");

        /**设置面板布局，并向面板中添加组件*/
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.add(label);
        panel.add(textField);
        panel.add(bConfirm);
        panel.add(bBack);

        /**为确定按钮添加事件监听，实现取款*/
        bConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                money = Double.parseDouble(textField.getText());
                boolean flag = false;
                try {
                    flag = ManagerImpl.getManager().deposit(money);

                    /**取款操作反馈*/
                    if (flag == true) {
                        JOptionPane.showMessageDialog(null, "存款成功！当前余额为：" + ManagerImpl.getManager().inquiry(), "存款", JOptionPane.PLAIN_MESSAGE);
                        depositFrame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "操作失败，请重新选择您的操作！", "存款", JOptionPane.PLAIN_MESSAGE);
                        depositFrame.dispose();
                    }
                } catch (AccountOverDrawnException e3) {
                    JOptionPane.showMessageDialog(null, "账户余额不足！");
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            }
        });
        /**为返回按钮添加事件监听，关闭当前窗口*/
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositFrame.dispose();
            }
        });
        /**将面板添加到框架中，并设置框架的相关信息*/
        depositFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
        depositFrame.add(panel);
        depositFrame.setSize(600, 400);
        depositFrame.setLocation(500, 400);
        depositFrame.setResizable(false);
        depositFrame.setVisible(true);
    }
}


/**
 * 转账界面
 */

class TransferFrame extends Frame {

    /**
     * 转入账户名
     */
    String zName;
    /**
     * 转账金额
     */
    double zMoney;

    public TransferFrame() {

        /**创建一个框架*/
        final JFrame transfersFrame = new JFrame("转账");

        /**创建一个面板*/
        JPanel panel = new JPanel();

        /**添加组件*/
        JLabel nameLabel = new JLabel("转入账户名：");
        JLabel moneyLabel = new JLabel("转账金额");
        final JTextField zNameTextField = new JTextField();
        final JTextField zMoneyTextField = new JTextField();
        JButton bConfirm = new JButton("确定");
        JButton bBack = new JButton("返回");

        /**添加事件监听器，匿名内部类*/
        bConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**从文本框获取转入账户名与转账金额*/
                zName = zNameTextField.getText();
                zMoney = Double.parseDouble(zMoneyTextField.getText());
                boolean flag = false;

                try {
                    flag = ManagerImpl.getManager().transfer(zName, zMoney);

                    if (flag == true) {
                        JOptionPane.showMessageDialog(null, "转账成功！当前余额为：" + ManagerImpl.getManager().inquiry(), "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);
                        transfersFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "转账失败！当前余额为：" + ManagerImpl.getManager().inquiry(), "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);
                        transfersFrame.dispose();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transfersFrame.dispose();
            }
        });

        /**设置面板布局，并向面板中添加组件*/
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.add(nameLabel);
        panel.add(zNameTextField);
        panel.add(moneyLabel);
        panel.add(zMoneyTextField);
        panel.add(bConfirm);
        panel.add(bBack);

        /**设置框架布局，将面板添加到面板中*/
        transfersFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        transfersFrame.add(panel);
        transfersFrame.setSize(600, 400);
        transfersFrame.setLocation(500, 400);
        transfersFrame.setResizable(false);
        transfersFrame.setVisible(true);

    }
}