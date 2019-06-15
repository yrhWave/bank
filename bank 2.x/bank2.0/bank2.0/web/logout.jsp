<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/21
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/Login.css"/>
<html>
<head>
    <title>注销</title>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1>注销成功</h1>
        </div>

        <div class="container">
            <p>两秒后跳转到首页，若未自动跳转请点击
                <stroy><a href="login.jsp">这里</a></stroy>
            </p>
            <br>
        </div>
    </div>
</div>
<%
    response.setHeader("refresh", "2,URL=login.jsp");
    session.invalidate();
%>
<%--<div id="login">
    <h3>注销成功</h3><br>

<h3>两秒后跳转到首页，若未自动跳转请点击<a href="login.jsp">这里</a> </h3>
<%
    response.setHeader("refresh","2,URL=login.jsp");
    session.invalidate();
%>--%>

</body>
</html>
