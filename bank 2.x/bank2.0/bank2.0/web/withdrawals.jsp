<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>取款</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>取款</h1>
        </div>
        <div class="container" align="center">

            <form action="withdrawals" method="post">
                <input type="text" required="required" placeholder="取款金额" name="money"/><br>
                <button class="but" type="submit">取款</button>
            </form>

        </div>
    </div>
</div>
<%--<div id="login">
<form action="withdrawals" method="post">
    <input type="text"  required="required" placeholder="取款金额"name="money"/>
    <button class="but" type="submit">取款</button>
</form>
</div>--%>
</body>
</html>
