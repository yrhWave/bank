<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>egister</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>注册账号</h1>
        </div>
        <div class="container" align="center">

            <form action="register" method="post">
                <input type="text" required="required" placeholder="用户名" name="uname">
                <input type="password" required="required" placeholder="密码" name="upsd">
                <button class="button" type="submit" style="vertical-align:middle"><span>注册 </span></button>
            </form>

        </div>
    </div>
</div>
</body>
</html>

