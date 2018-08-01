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
    <title>欢迎你，管理员</title>
</head>
<body>
<center>
    <%String counter1 = (String) application.getAttribute("counter1"); %>
    <%int n = Integer.valueOf(counter1); %>
    <p>欢迎你管理员 ${user.name}
    <p><%out.println("你是访问本管理员页面的第"+n+"人次"); %>
        <br><br>
        <a href="../../logoff">注销登陆</a>
        <a href="getallusers">查看所有用户</a>
        <a href="getalluserallarticles">查看当前数据库所有文章</a>
        <a href="getalluserallmessages">查看当前数据库所有留言</a>
        <br><br>
</center>
</body>
</html>