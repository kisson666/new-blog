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
    <title>所有用户</title>
</head>
<body>
<center><%List<User> users = (List<User>) request.getAttribute("users"); %>
    <%!long i = 1; %>
    <h1>所有用户如下</h1><br><br><br>
    <%for (User user : users) {%>
    <%out.println("第" + i + "位");%><br>
    <%out.println("用户ID为:" + user.id); %><br>
    <%out.println("用户最后上线时间:" + user.time); %>
    <form action="userdetail.jsp" method="post">
        <input type="hidden" name="id" value=<%=user.id %>>
        <input type="hidden" name="name" value=<%=user.name %>>
        <input type="hidden" name="password" value=<%=user.password %>>
        <input type="hidden" name="time" value="<%=user.time %>">
        <input type="hidden" name="i" value=<%=user.i %>>
        <input type="submit" value="查看此用户的信息">
    </form>
    <br><br><br>
    <%i++; %>
    <%}%>
    <%i = 1; %>
</center>
</body>
</html>