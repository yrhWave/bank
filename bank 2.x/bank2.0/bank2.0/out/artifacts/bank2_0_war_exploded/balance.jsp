<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>余额</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>操作成功</h1>
        </div>

        <div class="container">
            <p>当前余额为：<strong>${requestScope.balance}</strong></p>
            <p><a href="mainFrame.jsp">
                <button class="button2" style="vertical-align:middle"><span>返回主界面 </span></button>
            </a></p>
        </div>
    </div>
</div>
</body>
</html>
