<%@ page import="java.util.List" %>
<%@ page import="com.wang.model.Article" %>
<%@ page import="com.wang.model.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="../css/stylebutton.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>欢迎你，我的朋友</title>
</head>
<body>
<div style="position:fixed; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="../img/bg.jpg" height="100%" width="100%" style="left:0; top:0;">
</div>
<%--<canvas class='background' height='2000px' width='2000px'> </canvas>--%>
<div style="position: absolute;left: 1%;top: 0;font-size: 20px">
    <%
        String counter = (String) application.getAttribute("counter");
        User user = (User) session.getAttribute("user");
    %>
    <%int n = Integer.valueOf(counter); %>
    <p>欢迎你 <font color="red">${user.name}</font><br>
            <%out.println("你是访问本网站的第"+n+"人次"); %>
        <br>

        <a href="../logoff">注销登陆</a>&nbsp;<a href="privatemanagement.jsp">账号管理</a>&nbsp;<a href="myblog.jsp">我的博客</a>
        <br>
        <%--点击下面的链接后就会把session中的isreadmessage清除--%>
        <%--<br><br>--%>
        <%--<font color="red">不知道有哪些用户？</font><br>--%>
        <%--<a href="getranduser">给我推荐几个用户</a><br><br>--%>
        <%--<font color="red">不知道有哪些文章？</font><br>--%>
        <%--<a href="getrandarticle">给我推荐几篇文章</a><br><br>--%>
    <p>输入关键字进行搜索
    <form action="sercharticles" method="get">
        <input type="text" name="title">
        <input type="submit" value="搜索">
    </form>
    <%--<p>输入用户ID进行搜索<form action="sercharticles" method="get">--%>
    <%--<input type="text" name="id">--%>
    <%--<input type="submit" value="搜索">--%>
    <%--</form>--%>
    <p>输入用户ID查看TA的资料
    <form action="serchuser" method="get">
        <input type="text" name="id">
        <input type="submit" value="搜索">
    </form>
</div>

<div style="position: absolute;right: 2%;top: 0;">
    <%if (session.getAttribute("isReadMessage") != null) {%>
    <font color="red" size="6"><a href="isreadmessage?articleauthorid=<%=user.getId()%>">有新的留言</a></font>
    <%}%>
</div>

<center>
    <p>近期文章<br><br>
            <%!int i=1; %>
            <%List<Article> articles=(List<Article>)session.getAttribute("recentArticles");%>
            <%for(Article article:articles){%>
        <%--<% if(article.privatesee==0){%>--%>
        <font color="red"><%out.println("第" + i + "篇");%></font><br>
        <font color="red">标题:</font><% out.println(article.getApk().getTitle()+"  ");%>
        <font color="red">最后修改时间:</font><% out.println(article.time+"  ");%>
        <font color="red">作者的昵称:<a
                href="serchuser?id=<%=article.getApk().getId()%>"></font><%out.println(article.name+"  ");%></a>
    <form action="articleandmessage" method="get">
        <input type="hidden" name="cid" value=<%=article.cid %>>
        <input type="submit" value="点击查看此篇文章">
    </form>
    <br><br>
    <%i++; %>
    <%--<% }%>--%>
    <%}%>
    <%i = 1; %>
</center>

<script src="../js/jquery-1.11.1.min.js"></script>
</body>
</html>