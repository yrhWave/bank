<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/21
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title><bean:message key="title.transfer"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/Login.css"/>
</head>
<body>
<div align="center">
    <img src="../../image/v-bank.png"  width="400" height="200" alt="">
</div>
<div id="main">
    <div class="card">
        <div class="header">
            <h1><bean:message key="title.transfer"/></h1>
        </div>
        <div class="container" align="center">

            <form action="transfer.do" method="post">
                <input type="text"  required="required" placeholder='<bean:message key="user.transfer.payee"/> ' name="zName"><br>
                <input type="text"  required="required" placeholder='<bean:message key="user.transfer.money"/> ' name="zMoney"><br>
                <button class="but" type="submit"><bean:message key="user.button.submit"/></button>
            </form>

        </div>
    </div>
</div>
</body>
</html>
