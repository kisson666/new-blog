<%@page import="com.wang.model.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>删除账号</title>
</head>
<body>
<center>
    <%User user = (User) session.getAttribute("user"); %>
    <form action="deletemyaccount" method="post">
        <p>请输入你的密码:<input type="password" name="password"></p>
        <input type="hidden" name="id" value=<%=user.id %>>
        <input type="submit" value="删除账号" onclick='return confirm("真的要删除这个账号吗？")'>
    </form>
</center>
</body>
</html>