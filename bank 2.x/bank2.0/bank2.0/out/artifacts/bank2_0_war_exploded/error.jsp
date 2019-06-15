<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作错误</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>操作失败</h1>
        </div>

        <div class="container">
            <p>
                <stroy>${requestScope.errorInfo}</stroy>
            </p>
            <p><strong><a href="mainFrame.jsp">
                <button class="button2" style="vertical-align:middle"><span>返回主界面 </span></button>
            </a></strong></p>
        </div>
    </div>
</div>
<%--<h2>出错啦~</h2><hr>
<div id="login">
    <p>${requestScope.errorInfo}</p><br>
    <p>返回<a href="mainFrame.jsp">主界面</a></p>
    <div>--%>
</body>
</html>
