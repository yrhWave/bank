<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title><bean:message key="title.balance"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="../../image/v-bank.png" width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1><bean:message key="user.operatesuccessfully"/></h1>
        </div>

        <div class="container">
            <p><bean:message key="user.balance"/> ：<strong>${requestScope.balance}</strong></p>
            <p>
                <button class="button2" style="vertical-align:middle" onClick="javascript:history.go(-1);"><span><bean:message key="user.back"/> </span></button>
           </p>
        </div>
    </div>
</div>
</body>
</html>
