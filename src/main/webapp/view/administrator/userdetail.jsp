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
    <title>管理员查看用户的详细资料</title>
</head>
<body>
<center>
    <%request.setCharacterEncoding("utf-8"); %>
    <%String id = request.getParameter("id");%>
    <%String name = request.getParameter("name");%>
    <%String password = request.getParameter("password");%>
    <%String time = request.getParameter("time"); %>
    <%int i = Integer.valueOf(request.getParameter("i"));%>
    <font color="red"><h1>此用户的详细资料如下</h1></font><br><br>
    <font color="red"><p>用户ID:</p></font><%out.println(id); %>
    <br><br>
    <font color="red"><p>用户昵称:</p></font><%out.println(name); %>
    <br><br>
    <font color="red"><p>用户密码:</p></font><%out.println(password); %>
    <br><br>
    <font color="red"><p>最后上线时间:</p></font><%out.println(time); %>
    <br><br>
    <%if (i == 1) { %>
    <font color="red"><p>该用户是管理员</p></font>
    <%} else { %>
    <font color="red"><p>该用户不是管理员</p></font>
    <%} %>
    <form action="deleteuser" method="post">
        <input type="hidden" name="id" value=<%=id %>>
        <input type="hidden" name="password" value=<%=password %>>
        <input type="submit" value="点击删除此用户" onclick='return confirm("真的要删除这个账号吗？")'>
    </form>
    <form action="getuserallarticles" method="post">
        <input type="hidden" name="id" value=<%=id %>>
        <input type="submit" value="点击查看该用户所有文章">
    </form>
    <form action="getuserallmessage" method="post">
        <input type="hidden" name="id" value=<%=id %>>
        <input type="submit" value="点击查看该用户所有留言">
    </form>
</center>
</body>
</html>