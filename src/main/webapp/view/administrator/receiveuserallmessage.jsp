<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="java.util.List" %>
<%@page import="com.wang.model.Message" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        img {
            border: 0;
            margin: 0;
            padding: 0;
            max-width: 500px;
            width: expression(this.width>500?"500px":this.width);
            max-height: 500px;
            height: expression(this.height>500?"  500px":this.height);
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>管理员请求得到指定用户所写的所有留言</title>
</head>
<body>
<center>
    <%List<Message> messages = (List<Message>) request.getAttribute("messages"); %>
    <%!long i = 1; %>
    <%if (messages.isEmpty()) { %>
    <font color="red"><%out.println("TA暂时还没有给任何文章留过言");%></font><br>
    <%} else { %>
    <% for (Message message : messages) {%>
    <br><br>
    <font color="red"><%out.println("第" + i + "条  ");%></font><br>
    <font color="red">留言内容:</font><%out.println(message.content + "  ");%><br>
    <font color="red">留言时间:</font><%out.println(message.time + "  ");%><br>
    <font color="red">这条留言所在的文章:</font><%out.println(message.articletitle + "  ");%><br>
    <font color="red">文章作者的ID:</font><%out.println(message.articleauthorid + "  ");%><br>
    <font color="red">文章作者的昵称:</font><%out.println(message.articleauthorname + "  ");%>
    <form action="deleteusermessage">
        <input type="hidden" name="mid" value="<%=message.mid%>">
        <input type="submit" value="删除这条留言" onclick='return confirm("真的要删除这条留言吗？")'>
    </form>
    <form action="getuserarticleandmessage">
        <input type="hidden" name="cid" value="<%=message.cid%>">
        <input type="submit" value="查看这篇文章">
    </form>
    <br><br>
    <%i++;%>
    <% }%>
    <%i = 1; %>
    <%} %>
</center>
</body>
</html>