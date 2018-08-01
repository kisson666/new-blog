<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="com.wang.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="../css/stylebutton.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>我的博客</title>
</head>
<body>
<div style="position:fixed; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="../img/bg.jpg" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    ${info }<br><br><br><br><br><br>
    <%session.removeAttribute("info"); %>
    <%User user = (User) session.getAttribute("user"); %>
    <form action="writenewarticle.jsp" method="post">
        <input type="submit" value="写新的博客" style="font-size:30px">
    </form>
    <br><br>
    <form action="myblogarticlestitle" method="post">
        <input type="hidden" name="id" value=<%=user.id %>>
        <input type="submit" value="查看我的所有博客" style="font-size:30px">
    </form>
    <br><br>
    <form action="myblogmyallmessage" method="post">
        <input type="hidden" name="id" value=<%=user.id %>>
        <input type="submit" value="查看我自己写的所有留言" style="font-size:30px">
    </form>
    <br><br>
</center>
</body>
</html>