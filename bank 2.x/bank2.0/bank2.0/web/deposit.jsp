<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>存款</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>存款</h1>
        </div>
        <div class="container" align="center">

            <form action="deposit" method="post">
                <input type="text"  required="required" placeholder="存款金额" name="money"/>
                <button class="but" type="submit">存款</button>
            </form>

        </div>
    </div>
</div>
<%--<h2>存款</h2><hr>
<div id="login">
<form action="deposit" method="post">
<input type="text"  required="required" placeholder="存款金额" name="money"/>
    <button class="but" type="submit">存款</button>
</form>
</div>--%>
</body>
</html>
