<%--
  Created by IntelliJ IDEA.
  User: 余融化
  Date: 2018/8/20
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>银行主界面</title>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>

<body>
<br>
<br>
<div id="q">
    <div id="header">
        <h1 >欢迎使用  V.BANK</h1>
    </div>
    <div id="six">
        <p>请选择您要</p>
        <p>办理的业务</p>
    </div>
    <div id="one"><a href="inquiry"><img src="image/查询.png" width="200" height="200" alt=""></a></div>
    <div id="two"><a href="deposit.jsp"><img src="image/存款.png" width="200" height="200" alt=""></a></div>
    <div id="three"><a href="withdrawals.jsp"><img src="image/取款.png" width="200" height="200" alt=""></a></div>
    <div id="four"><a href="transfer.jsp"><img src="image/转账.png" width="200" height="200" alt=""></a></div>
    <div id="five"><a href="logout.jsp"><img src="image/注销.png" width="200" height="200" alt=""></a></div>
</div>
</body>
</html>
