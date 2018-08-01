<%@page import="java.util.List" %>
<%@page import="com.wang.model.Article" %>
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
    <title>我的所有博客</title>
</head>
<body>
<div style="position:fixed; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="../img/bg.jpg" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    <%List<Article> articles = (List<Article>) request.getAttribute("articles");%>
    <%!int i = 1; %>
    <%if (articles.isEmpty()) {%>
    <font color="red"><%out.println("暂时还没有相关的文章哦！");%></font>
    <% } else {%>
    <%for (Article article : articles) {%>
    <font color="red"><% out.println("第" + i + "篇");%></font><br>
    <font color="red">标题:</font><% out.println(article.getApk().getTitle() + "  ");%>
    <font color="red">最后修改时间:</font><% out.println(article.time + "  ");%><br>
    <form action="myblogarticlescontent" method="post">
        <input type="hidden" name="cid" value=<%=article.cid %>>
        <%if (article.privatesee == 1) {%>
        <font color="red">它是仅自己可见的</font>
        <% }%>
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