<%@page import="java.util.List" %>
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
    <title>推荐用户</title>
</head>
<body>
<center>
    <%List<User> users = (List<User>) request.getAttribute("users"); %>
    <%for (User user : users) {%>
    <a href="serchuser?id=<%=user.id%>"><%out.println(user.name); %></a><br><br>
    <%}%>
</center>
</body>
</html>