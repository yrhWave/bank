<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title><bean:message key="title.deposit"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="../../image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1><bean:message key="title.deposit"/></h1>
        </div>
        <div class="container" align="center">

            <form action="/deposit.do" method="post">
                <input type="text"  required="required" placeholder='<bean:message key="user.deposit.money"/> ' name="money"/>
                <button class="but" type="submit"><bean:message key="user.button.submit"/></button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
