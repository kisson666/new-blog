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
    <title>修改我的个人资料</title>
</head>
<body>
<center>
    <%User user = (User) session.getAttribute("user"); %>
    <font color="red"><p>由于开发者水平有限，能修改的资料目前只有昵称……请谅解</p></font><br>
    <form action="changemydata" method="post">
        <p>请输入你的新昵称:<input type="text" name="name" value=<%=user.name %>></p>
        <input type="hidden" name="id" value=<%=user.id %>>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>