<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="java.util.List" %>
<%@page import="com.wang.model.Article" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>管理员查看用户的所有文章</title>
</head>
<body>
<center>
    <%!int i = 1; %>
    <%List<Article> articles = (List<Article>) request.getAttribute("articles");%>
    <%if (articles.isEmpty()) {%>
    <font color="red"><%out.println("暂时还没有相关的文章哦！");%></font>
    <% } else {%>
    <%for (Article article : articles) {%>
    <font color="red"><%out.println("第" + i + "篇");%></font><br>
    <font color="red">标题:</font><% out.println(article.title + "  ");%>
    <font color="red">最后修改时间:</font><% out.println(article.time + "  ");%>
    <font color="red">作者的ID:</font><%out.println(article.id + "  ");%>
    <font color="red">作者的昵称:</font><%out.println(article.name + "  ");%><br>
    <%if (article.privatesee == 1) {%>
    <font color="red">它是仅自己可见的</font>
    <%}%>
    <form action="getuserarticleandmessage" method="get">
        <input type="hidden" name="cid" value=<%=article.cid %>>
        <input type="submit" value="点击查看此篇文章">
    </form>
    <br><br>
    <%i++; %>
    <%}%>
    <%i = 1; %>
    <%}%>
</center>
</body>
</html>