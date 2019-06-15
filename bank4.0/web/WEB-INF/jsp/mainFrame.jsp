<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title><bean:message key="title.mainFrame"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/main.css"/>
</head>

<body>
<br>
<br>
<div id="q">
    <div id="header">
        <h1 ><bean:message key="user.welcometouse"/> </h1>
    </div>
    <div id="six">
        <p><bean:message key="user.Please1"/></p>
        <p><bean:message key="user.Please2"/></p>
    </div>
  <%--  <div id="one"><a href="/manager.do?command=inquiry"><img src="../../image/查询.png" width="200" height="200" alt=""></a></div>--%>
    <div id="one"><a href="/inquiry.do"><img src="../../image/查询.png" width="200" height="200" alt=""></a></div>
    <div id="two"><a href="/deposit"><img src="../../image/存款.png" width="200" height="200" alt=""></a></div>
    <div id="three"><a href="/withdrawals"><img src="../../image/取款.png" width="200" height="200" alt=""></a></div>
    <div id="four"><a href="/transfer"><img src="../../image/转账.png" width="200" height="200" alt=""></a></div>
    <div id="five"><a href="/logout"><img src="../../image/注销.png" width="200" height="200" alt=""></a></div>
</div>
</body>
</html>
