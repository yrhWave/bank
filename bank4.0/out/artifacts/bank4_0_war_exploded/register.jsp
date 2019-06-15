<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/9/3
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><bean:message key="title.register"/></title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png" width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1><bean:message key="title.register"/></h1>
        </div>
        <div class="container" align="center">
            <form action="register.do" method="post">
                <input type="text" required="required" placeholder='<bean:message key="user.username"/> '
                       name="userName">
                <input type="password" required="required" placeholder='<bean:message key="user.password"/> '
                       name="userPassword">
                <button class="button" type="submit" style="vertical-align:middle"><span><bean:message
                        key="user.register"/></span></button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

