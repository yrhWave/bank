<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/16
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
   <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>登录操作</h1>
        </div>
        <div class="container" align="center">

            <form action="login" method="post">
                <input type="text" required="required" placeholder="用户名" name="uname">
                <input type="password" required="required" placeholder="密码" name="upsd">
                <button class="button" type="submit" style="vertical-align:middle"><span>登录 </span></button>
                <p>没有账号？<a href="register.jsp">注册</a>一个~</p>
            </form>

        </div>
    </div>
</div>

</body>
</html>

