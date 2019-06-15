<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<link rel="stylesheet" type="text/css" href="css/Login.css"/>
<html>
<head>
    <title>异常信息</title>
    <link rel="stylesheet" type="text/css" href="css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="image/v-bank.png" width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1><bean:message key="title.error"/></h1>
        </div>
        <div class="container" align="center">
            <p><html:errors/><br></p>
            <p><strong><a href="login.jsp">
                <button class="button2" style="vertical-align:middle"><span><bean:message key="user.back"/></span></button>
            </a></strong></p>
        </div>
    </div>
</div>
</body>
</html>
