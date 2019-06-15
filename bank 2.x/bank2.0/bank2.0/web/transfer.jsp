<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/21
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>转账</h1>
        </div>
        <div class="container" align="center">

            <form action="transfer" method="post">
                <input type="text"  required="required" placeholder="收款账户"name="zName"><br>
                <input type="text"  required="required" placeholder="转账金额" name="zMoney"><br>
                <button class="but" type="submit">转账</button>
            </form>

        </div>
    </div>
</div>

<%--<h2>转账</h2><hr>
<div id="login">
    <form action="transfer" method="post">
        <input type="text"  required="required" placeholder="收款账户"name="zName"><br>
        <input type="text"  required="required" placeholder="转账金额" name="zMoney"><br>
        <button class="but" type="submit">转账</button>
    </form>
</div>--%>
</body>
</html>
