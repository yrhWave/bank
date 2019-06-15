<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/21
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/Login.css"/>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title><bean:message key="title.logout"/></title>
</head>
<body>
<div align="center">
    <img src="../../image/v-bank.png" width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1><bean:message key="title.logout"/></h1>
        </div>

        <div class="container">
            <p><bean:message key="user.logout.message"/>&nbsp
                <stroy><a href="../../login.jsp"><bean:message key="user.logout.message2"/> </a></stroy>
            </p>
            <br>
        </div>
    </div>
</div>
<%
    response.setHeader("refresh", "2,URL=login.jsp");
    session.invalidate();
%>
</body>
</html>
