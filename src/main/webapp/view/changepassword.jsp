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
    <title>修改密码</title>
</head>
<body>
<center>
    <%User user = (User) session.getAttribute("user"); %>
    <form action="changemypassword" method="post">
        <p>请输入原来的密码:<input type="password" name="oldpassword"></p>
        <p>请输入新的密码:<input type="password" name="newpassword1"></p>
        <p>请再次输入新的密码:<input type="password" name="newpassword2"></p>
        <input type="hidden" name="id" value=<%=user.id %>>
        <input type="submit" value="确认修改">
    </form>
</center>
</body>
</html>